// GraphBFS.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include<set>   
#include <queue>
using namespace std;


template<class T>
class Node {
	private:
		T data;
		set<Node<T>*> *relation;   //set, contains nodes that associated with this node

	public:
		Node(T data) {
			cout << "constructor, node is created: "<< data << endl;
			this->data = data;
			this->relation = new set<Node<T>*>();
		}
		T getData() {
			return data;
		}

		set<Node<T>*> neighbors() {
			return *relation;
		}

		void addRelation(Node<T>* vertex) { //pointer copy, a copy pointer to the same memory address
											 //o(n)   need to check
			for (auto it1 = relation->begin(); it1 != relation->end(); ++it1) {
				if ((*it1) == vertex) {
					return;
				}
			}
			this->relation->insert(vertex);
		}

		void printRelations() {  //o(n) for printing all elements in a set
			cout << this->data << "  |";
			for (auto it1 = relation->begin(); it1 != relation->end(); ++it1) {
				cout << (*it1)->getData() << "  ";
			}
			cout << endl;
		}

		void deleteVertex(Node<T>*& vertex) {
			//cout << "................." << endl;
			set<Node<T>*> *newrelation= new set<Node<T>*>();

			for (auto it1 = relation->begin(); it1 != relation->end(); ++it1) {
				if ((*it1) == vertex) {
					continue;
				}
				//cout << "adj " <<this->data<< "  "<<(*it1)->getData() << endl;
				newrelation->insert(*it1);
			}
			this->relation = newrelation;
			//cout << "relation" << endl;
			//this->printRelations();
		}
		
		

		~Node() {
			cout << "Node Destructor "<<this->data << endl;
			delete this->relation;
		}

};

template<class T>
class Graph {    //Graph is an  Adjecency-List representation
	private:
		set<Node<T>*> *graph;

	public:
		Graph() {
			this->graph = new set<Node<T>*>();
		}

		void add(T data) { //inserting node o(n)
			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				if ((*it1)->getData() == data) {
					return;
				}
			}
			Node<T> *vertex = new Node<T>(data);
			this->graph->insert(vertex);
		}

		void createEdge(T data1, T data2) {
			bool exist1 = false;
			bool exist2 = false;
			Node<T> *vertex1 = NULL; Node<T> *vertex2 = NULL;
			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				if ((*it1)->getData() == data1) {
					exist1 = true;
					vertex1 = *it1;
				}
				if ((*it1)->getData() == data2) {
					exist2 = true;
					vertex2 = *it1;
				}
			}
			// can create relation if only both exist (have been add to the graph)
			if (exist1&&exist2) {
				vertex1->addRelation(vertex2);
				vertex2->addRelation(vertex1);

			}



		}
		
		void printVertexs() {  //o(n) for printing all elements in a set
			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				cout << (*it1)->getData() << " ";
			}
			cout << endl;
		}

		void adjecentList() {
			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				(*it1)->printRelations();
			}
			cout << endl;
		}
		
		void removeVertex(T data) {
			Node<T> *toDelete = NULL;
			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				if ((*it1)->getData() == data) {
					
					toDelete = *it1;
					break;
				}
				
			}
			if (toDelete) { //delete is dected
			    cout << "Node "<<toDelete->getData()<<" is deleted"<<endl;
				set<Node<T>*> *newgraph=new set<Node<T>*>();
				set<Node<T>*> *oldGraph = this->graph;
				for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
					if (*it1 == toDelete) {
						continue;
					}
					 (*it1)->deleteVertex(toDelete);
					 newgraph->insert(*it1);
				}
				this->graph = newgraph;
				delete oldGraph;
				delete toDelete;
			}
		}
		

		bool BFS(T start,T destination) {
			Node<T>* root = NULL; Node<T>* end = NULL;
			//find the root, starting point in the graph first
			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				if ((*it1)->getData() == start) {
					root = *it1;
					break;
				}
			}

			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				if ((*it1)->getData() == destination) {
					end = *it1;
					break;
				}
			}
			//start and end must be valid
			if (!root) {
				return false;
			}
			if (!end) {
				return false;
			}
			if (root == end) {
				return true;
			}
			queue <Node<T>*> q;
			set<Node<T>*> visited;
			q.push(root);
			//cout << root->getData() << " root" << endl;

			while (!q.empty()) {
				 Node<T> *temp = q.front();
				 q.pop();
				 if (temp->getData() == destination) {
					// cout << "return true" << endl;
					 return true;
				 }
				 visited.insert(temp);
				 set<Node<T>*> neighbors = temp->neighbors();

				 for (auto it1 = neighbors.begin(); it1 != neighbors.end(); ++it1) {
					// cout << temp->getData()<<"cur  neighbors " << (*it1)->getData()<<"    ";
					 if (visited.find((*it1)) != visited.end() ) {
						 continue;
					 }
					 q.push((*it1));
				 }
				// cout << endl;
			}

			return false;


		}

		~Graph() {
			for (auto it1 = graph->begin(); it1 != graph->end(); ++it1) {
				delete *it1;
			}
			delete graph;
		
		}

};


int main()
{
	//Node<double> node(10.5);
	//node.addRelation(10.0);
	//node.addRelation(2.5);
	//node.addRelation(2.51);
	//node.printRelations();
	Graph<int> graph;
	graph.add(1);
	graph.add(2);
	graph.createEdge(1, 2);
	graph.createEdge(1, 2);
	graph.add(3);
	graph.add(4);
	graph.createEdge(1, 3);
	graph.createEdge(2, 3);
	graph.createEdge(1, 4);
	graph.adjecentList(); //print the graph 
	graph.removeVertex(3);
	graph.adjecentList();
	graph.removeVertex(4);
	graph.adjecentList();
	graph.removeVertex(1);
	graph.adjecentList();
	graph.removeVertex(2);
	graph.adjecentList();
	cout << endl << endl << endl;
	cout << "......................................." << endl;
	cout << "Above is the testing program for the graph" << endl;
	cout << endl << endl << endl; cout << endl << endl << endl;
	Graph<char> graph1;
	graph1.add('A'); graph1.add('B'); graph1.add('C'); graph1.add('D'); graph1.add('K'); graph1.add('L');
	graph1.add('J'); graph1.add('M'); 
	graph1.createEdge('A','B'); graph1.createEdge('A', 'C'); graph1.createEdge('A', 'D');
	graph1.createEdge('D', 'K'); graph1.createEdge('D', 'L'); graph1.createEdge('L', 'J'); graph1.createEdge('J', 'M');
	graph1.add('W'); //W is disconnect form the graph
	graph1.adjecentList();

	if (graph1.BFS('C', 'M')) {
		cout << "True" << endl;
	}
	else {
		cout << "False" << endl;
	}

	if (graph1.BFS('A', 'M')) {
		cout << "True" << endl;
	}
	else {
		cout << "False" << endl;
	}


	if (graph1.BFS('A', 'W')) {
		cout << "True" << endl;
	}
	else {
		cout << "False" << endl;
	}

	if (graph1.BFS('C', 'W')) {
		cout << "True" << endl;
	}
	else {
		cout << "False" << endl;
	}


    return 0;
}
