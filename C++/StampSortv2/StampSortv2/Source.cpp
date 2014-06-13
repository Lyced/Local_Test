#include <iostream>
#include <stack>
using namespace std;
#include <math.h>
#include <stamp.h>
#include <collection.h>

int main () {

	int amount;
	collection stamplist;
	stack<int> tempStamps;

	amount = -1;

	stamplist.getValues(tempStamps);  //get the values of the stamp collection
	stamplist.showValues();  //output the values to check if the get and sort logic works as needed

	while (amount != 0) {

		cout <<"Please enter the amount (0 to exit, 9999 to re-enter stamp values): ";
		cin >> amount;

		if (amount == 9999) {

			stamplist.getValues(tempStamps);
			
		} else if (amount < 0) {

			cout <<"Invalid amount entered. Values cannot be negative" <<endl;

		} else {
			//call procedure to determine the amount of stamps needed

			cout <<"The results for the first method is" <<endl;
			stamplist.firstMethod(amount);

			cout<<"--------------------------------------------------------" <<endl;
			
			cout <<"The results for the second method is" <<endl;
			stamplist.secondMethod(amount);

			cout<<"--------------------------------------------------------" <<endl;
			
			if (stamplist.list[0].value == 9 && stamplist.list[1].value == 7 && stamplist.list[2].value == 2 && amount != 0) {
				// if the values match that of the original problem, out the results of the old code
				stamplist.oldcode(amount);
			}

		}
	}
}