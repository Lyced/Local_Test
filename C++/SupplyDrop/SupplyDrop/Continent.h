class continent {
private:
	int i, j, x, count, diff1, diff2, lowest, secondLowest, dropMove, targetLocation, baseProbabilities[20];
	double randNum, secondLowAmount, lowAmount;

public:

	double hcount[18];
	int *village, totalDrops;

	continent();
	int nextVillage(int planeLocation, int numofvill);
	int supplyLand(int planeLocation, int numofvill);
	void displayResults(int numofvill, int factor);
	void updateVillages(int numofvill);
	int supplyAmount();
};

continent::continent() {
	static const int maxvill = 5;
	count = 40; //the least amount of supplies possible to survive a drop
	village = new int [maxvill*100];
	totalDrops = 0;
	for (i = 0; i < 21; i++) {

		baseProbabilities[i] = count++;	//creates an array of 21 spaces big to hold all the possible amounts supplies that will survive

	};
}

int continent::supplyAmount() { //function to determine the amount of supplies that will make it.
		
	x = (int) ((rand() / (RAND_MAX + 1.0) * 21));

	return baseProbabilities[x];	//returns the appropriate amount with the array of poosible amounts
}


void continent::updateVillages(int numofvill) {

	delete [] village;
	village = new int [numofvill];

	for (j = 0; j < 18; j++) {

		hcount[j] = 0;	//resets the array for next use

	}
	totalDrops = 0;
}

int continent::supplyLand (int planeLocation, int numofvill) {	//function to determine where the supplies will land
	
	randNum = (rand() / (RAND_MAX + 1.0)) * 100;

	if (randNum <= 32) {

		dropMove = 0;	//if random number is within the 32% range then the drop will not move

	} else if (randNum <= 54) {

		dropMove = 1;	//if the random number is within the 24% range of it moving to the right one village

	} else if (randNum <= 76) {

		dropMove = -1;	//if the random number is within the 24% range of it moving to the left one village

	} else if (randNum <= 88) {

		dropMove = 2;	//if the random number is within the 12% range of it moving to the right two village

	} else if (randNum > 88) {

		dropMove = -2;	//if the random number is within the 12% range of it moving to the left two village

	}

	targetLocation = planeLocation + dropMove;	//which actual village will it land in

	if (targetLocation < 0 || targetLocation >= numofvill) {

		return -1;	//if the supplies land in the water then return -1

	} else {

		return targetLocation;	//else the village in with the supplies land in is returned

	}
}

int continent::nextVillage (int planeLocation, int numofvill) {

	secondLowest = 0;
	lowest = 0;
	lowAmount = village[0];
	secondLowAmount = village[1];

	for (i = 0; i < numofvill; i++) {

		if (village[i] <= lowAmount) {	//finds the village with the least amount of supplies
			
			secondLowAmount = lowAmount;
			secondLowest = lowest;
			lowAmount = village[i];
			lowest = i;

		}

	}

	if (village[secondLowest] == village[lowest]) {	//if the two villages have the same amount then use the following as a tiebreaker by finding which village requires the least amount of travel time from the middle

		diff1 = (int) (abs((numofvill / 2) - lowest));
		diff2 = (int) (abs((numofvill / 2) - secondLowest));

		if (diff1 < diff2) {

			return lowest;	//if the first village chosen is closer to the center of the village then they will get the drop

		} else {

			return secondLowest;	//likewise if the other village is closer then they will get it

		}

		if (diff1 == diff2) {

			diff1 = abs(planeLocation - lowest);
			diff2 = abs(planeLocation - secondLowest);

			if (diff1 < diff2) {

				return lowest;	//if both villages are equally distanced from the center, then the one closest to the plane will receive it

			} else {

				return secondLowest;	//likewise if the other one is closer then they will get it

			}
		}
	}

	return lowest;	//if there were no ties, then return the village with the least amount supplies

}

void continent::displayResults(int numofvill, int factor){
	
	cout <<"   Number of Drops        Probability (%)\n"
		<<"------------------------------------------" <<endl;	//create the table header

	for (i = 0; i < 17; i++) {	//loop to output the first 17 values of the array in percent of probability

		cout <<setiosflags (ios::fixed) <<setw(8) <<setprecision(0) <<((numofvill * 2) + ((i * factor) + i)) <<" to " <<((numofvill * 2) + ((i * factor) + i) + factor) 
			<<setw(21) <<setprecision(3) <<((hcount[i] / 40000) * 100) << endl;
	}

	cout <<setprecision(0) <<setw(6) <<((numofvill * 2) + ((17 * factor) + 17)) <<" and above" 
		<<setprecision(3) <<setw(19) <<((hcount[17] / 40000) * 100) <<endl <<endl;	//outputs the last value of the array
	cout <<setprecision(0) <<"Average number of drops was: " <<setprecision(3) <<(totalDrops / 40000) <<endl;	//outputs the average number of drops made per campaign
	
}
