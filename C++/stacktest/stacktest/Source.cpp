#include <iostream>
#include <stack>
using namespace std;

int main() {
	
	int value;
	stack<int> temp;

	value = -1;

	while (value !=0) {

		cout <<"Please enter a value: ";
		cin >> value;

		temp.push(value);
	}

	cout <<"The stack size is " <<temp.size() <<endl;
	cout <<"The values in the stack are:" <<endl;

	while (!temp.empty()) {
		cout <<temp.top() << endl;
		temp.pop();
	}

	while (value != 9999) {
		cout <<"Please enter 0 to exit:" <<endl;
		cin >> value;
	}
}