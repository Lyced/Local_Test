class collection {
private:
	
	int section1, section2, section3, section4, section5, section6, section7, section8, section9, two, seven, nine;
	
	int stampvalue, count, size, n, d, f, sc, holding, remainder, *validFactors, currentStamps, currentTotal, testnumber;
	stack<int> Factors;
	void sortValues(stack<int> &tempStamps); //gets the values and puts them into a sorted array
	void displayResults(int amount);
	void calcFactors(int amount);
	void cleanValues();
	void calcResults();
	void checkMin(int amount);

public:

	int minstamps, mincost;
	stamp *list;
	collection();
	//~collection();
	void getValues(stack<int> &tempStamps);
	void firstMethod(int amount);
	void secondMethod(int amount);
	void showValues();

	void oldcode (int amount);
};

collection::collection(){
	const int defaultsize = 3;
	list = new stamp[defaultsize];
	validFactors = new int[defaultsize];
	stampvalue = -1;
	count = 0;
	size = defaultsize;
	mincost = 0;
	minstamps = 0;
	currentStamps = 0;
	currentTotal = 0;
}
/**
collection::collection(int listsize){
	stamplist = new stamp[listsize];
	stampvalue = -1;
	count = 0;
	size = listsize;
}**/

collection::~collection() {
	delete [] list;
	delete [] validFactors;
}

void collection::getValues(stack<int> &tempStamps) {

	stampvalue = -1;

	while (stampvalue != 0) {
		cout <<"Enter the value of a stamp (enter 0 to complete): ";
		cin >> stampvalue;
		
		if(stampvalue == 0) {
			break;
		}

		if (stampvalue < 0) {
			cout <<"Stamp values cannot be negative." <<endl;
		} else {
			tempStamps.push(stampvalue);
			cout <<"value " <<tempStamps.top() <<" was pushed" <<endl;
		}
		//use stack to temporarily hold values/objects and to count the number of stamps entered
	}

//	cout <<"stack size is " <<tempStamps.size() <<endl;
	
	sortValues(tempStamps);
}

void collection::sortValues(stack<int> &tempStamps) {

	delete [] list;

	list = new stamp[tempStamps.size()];
	size = tempStamps.size();
	
	while (!tempStamps.empty()) {
		
		list[count].value = tempStamps.top();

		cout <<"Stack element " <<(count +1) <<" has " <<tempStamps.top() <<endl;

		tempStamps.pop();

		count++;
	}

//	cout <<"Array size is " <<size <<endl;

	count = size-1;  // setting the number of elements in the array
	
	while (count != 0) {
		
		for (n = 0; n!=count; n++) {

			if (list[n].value == list[n+1].value) {

			//	cout <<"There are duplicate values at " <<unsortedlist[n].value <<" & " <<unsortedlist[n+1].value <<endl;
				list[n+1].value = list[size-1].value;
				count = --size;
				break;

			} else {

				if (list[n].value < list[n+1].value) {
					//sorting the values in the array into descending order
					holding = list[n+1].value;
					list[n+1].value = list[n].value;
					list[n].value = holding;

				}
			}
		}
		count--;
	}
}

void collection::showValues() {

	for (n = 0; n < size; n++) {
		cout <<"Array element " <<(n+1) <<" contains " <<list[n].value <<endl;
	}
}

void collection::cleanValues() {
	//minstamps = 0;
	//mincost = 0;
	for (n = 0; n < size; n++) {
		list[n].numofStamps = 0;
	}
}

void collection::firstMethod(int amount) {
	
	remainder = amount; //set the remainder to the amount originally at the beginning

	cleanValues();

	for (n = 0; n < size; n++) {

		if (remainder >= list[n].value) {

			list[n].numofStamps = (remainder / list[n].value);
			remainder = (remainder % list[n].value);

			if (remainder == 0) {
				break;
			}
		}
	}

	if (remainder > 0 && remainder < list[size-1].value) {

		list[size-1].numofStamps++;

	}

	calcResults();

	checkMin(amount);

	displayResults(amount);
/*
	delete [] list;
	delete [] validFactors;*/

}

void collection::secondMethod(int amount) {
	
	//calcFactors(amount); // find the set of factors of the amount in which to compare the list of stamp values that are available
	//count = size - 1;

	//firstMethod(amount);
	//since the second method is called after the first one, the results should still be in the object

	for (n = 0; n < size; n++) {

		while (list[n].numofStamps > 0) {

			cout <<"n value is " << n <<" and currentTotal is " <<currentTotal <<endl;
			if (currentTotal != amount) {
				list[size-1].numofStamps--;
				remainder += list[size-1].value;
				currentTotal -= list[size-1].value;
			}

			list[n].numofStamps--;
			remainder += list[n].value;
			currentTotal -= list[n].value;

			sc = n + 1;

			for (sc; sc < size; sc++) {

				if (remainder >= list[sc].value) {

					list[sc].numofStamps += (remainder / list[sc].value);
					remainder = (remainder % list[sc].value);

					if (remainder == 0) {
						break;
					}
				}
			}
	
			if (remainder > 0 && remainder < list[size-1].value) {
				list[size-1].numofStamps++;
			}

			calcResults(); // calculate the total cost and stamps for this round

			checkMin(amount);
			
			//count--;
		}
	}

	displayResults(amount);
}

void collection::calcResults() {

	for (d = 0; d < size; d++){
		if (list[d].numofStamps > 0) {
			currentStamps += list[d].numofStamps;
			currentTotal += (list[d].numofStamps * list[d].value);
		}
	}

}

void collection::checkMin(int amount) {

	if (minstamps < currentStamps && mincost == amount) {

		return;

	} else if ((minstamps == 0 && mincost == 0) || (minstamps > currentStamps && mincost > currentTotal) || (mincost > currentTotal && minstamps < currentStamps)) {
			
		mincost = currentTotal;
		minstamps = currentStamps;

		for (d = 0; d < size; d++){
			list[d].MinNumofStamps = list[d].numofStamps;
		}
	}

	//cout <<"Something isn't quite right..." <<endl;
	//return;
}

void collection::displayResults(int amount) {

	cout <<"For an amount of " <<amount <<" the following is needed:" <<endl;

	for (d = 0; d < size; d++){
		cout <<list[d].MinNumofStamps <<" " <<list[d].value <<"-value stamps." <<endl;
	}

	cout <<"Total number of stamps needed is " <<minstamps <<" costing " <<mincost <<endl;
}

void collection::calcFactors(int amount) {

	for (testnumber = 1; testnumber < amount; testnumber++) {

		if (amount % testnumber == 0) {

			Factors.push(testnumber);

		}
	}

	delete [] validFactors;
	validFactors = new int[Factors.size()];

	for (f = 0; !Factors.empty(); f++) {

		validFactors[f] = Factors.top();
		Factors.pop();
		cout <<"Value " <<validFactors[f] <<" is a factor." <<endl;

		for (n = 0; n < size; n++) {
			if ((validFactors[f] % list[n].value) == 0) {
				cout <<"Value " <<validFactors[f] <<" can be fulfilled with " <<(validFactors[f]/list[n].value) <<" " <<list[n].value << "stamps." <<endl;
			}
		}
	}
}

void collection::oldcode (int amount) {
//function to calculate the minimum amount of stamps required

	two = seven = nine = 0;

	section1 = 1;
	section2 = 2;
	section3 = 3;
	section4 = 4;
	section5 = 5;
	section6 = 6;
	section7 = 7;
	section8 = 8;
	section9 = 9;	//there are 9 different sections each with there special properties of getting the minimum amount

	switch (amount) {
	case 1:
		two = 1;
		break;
	case 2:
		two = 2;
		break;
	case 5:
		two = 3;
		break;
	}	//the first few numbers do not fall into the 9 sections above therefore they are defined here
			
	while (section1 != amount && section2 != amount && section3 != amount && section4 != amount && section5 != amount && section6 != amount && section7 != amount && section8 != amount && section9 != amount) {

		section1 += 9;
		section2 += 9;
		section3 += 9;
		section4 += 9;
		section5 += 9;
		section6 += 9;
		section7 += 9;
		section8 += 9;
		section9 += 9;	//adding 9 to all sections cover all the positive amounts until one section matches the values inputted
	
	}

	if (section1 == amount && amount >= 28) {

		nine = (amount - 28) / 9;
		seven = 4;

	} else if (section1 == amount && amount < 28) {

		nine = (amount - 10) / 9;
		two = 5;	//in order to get the minimum amount, section1 will always have 4 7 cent stamps when the inputted value is 28 and over, and will have 2 cent stamps when it is less thab 28

	}

	if (section2 == amount) {
	
		nine = (amount - 2) / 9;
		two = 1;	//special property of section2, any numbers in section2 will require x # of nine stamps and one 2 cent stamp

	}

	if (section3 == amount && amount >= 21) {

		nine = (amount - 21) / 9;
		seven = 3;	//special property of section3, any numbers in section3 will require x # of nine stamps and three 7 cent stamps when the inputted value is 21 and over

	}else if (section3 == amount && amount < 21) {

		two = 6;	//or it will have six 2 cent stamps when less than 21

	}

	if (section4 == amount) {

		nine = (amount - 4) / 9;
		two = 2;	//special property of section4, any numbers in section4 will require x # of nine stamps and two 2 cent stamps

	}

	if (section5 == amount && amount >= 14) {

		nine = (amount - 14) / 9;
		seven = 2;	//special property of section5, any numbers in section5 will require x # of nine stamps and two 7 cent stamps
		
	}

	if (section6 == amount && amount >= 3 && amount <= 33) {

		nine = (amount - 6) / 9;
		two = 3;	//special property of section6, any numbers in section6 will require x # of nine stamps and three 2 cent stamps in the given condition

	} else if (section6 == amount && amount >= 42) {

		nine = (amount - 42) / 9;
		seven = 6;	//or six 7 cent stamps if the inputted value is over 42

	}

	if (section7 == amount) {

		nine = (amount - 7) / 9;
		seven = 1;	////special property of section7, any numbers in section7 will require x # of nine stamps and one 7 cent stamps

	}

	if (section8 == amount && amount >= 8 && amount <= 26) {

		nine = (amount - 8) / 9;
		two = 4;	//special property of section8, any numbers in section8 will require x # of nine stamps and four 2 cent stamps in the given condition

	} else if (section8 == amount && amount >= 35) {

		nine = (amount - 35) / 9;
		seven = 5;	//or five 7 cent stamps in the inputted value is 35 n over
		
	}

	if (section9 == amount) {

		nine = amount / 9;	//special property of section9, any numbers in section9 will require x # of nine stamps

	}	

	cout <<"# of 9 cent stamps: " <<nine <<endl
		<<"# of 7 cent stamps: " <<seven <<endl
		<<"# of 2 cent stamps: " <<two <<endl
		<<"Total stamps: " <<(nine+seven+two) <<endl;
}