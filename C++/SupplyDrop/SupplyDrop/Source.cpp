#include <iostream>
#include <iomanip>
using namespace std;
#include <stdlib.h>
#include <limits.h>
#include <math.h>
#include <Continent.h>

void main () {	//main function

	int i, j, k, numofdrops, numofvill, nextTarget, planeLocation, actualLanding, factor, ccount;
	continent world;

	for (;;) {

		cout <<"Enter the amount of villages on the island (Enter 0 to exit): ";
		cin >> numofvill;

		factor = numofvill / 3;	//a factor used in categorizing the number of drops
		planeLocation = numofvill / 2;	//initial starting location of the plane

		if (numofvill == 0) {

			return;	//if the 0 is entered the exit

		}

		if (numofvill < 0) {

			cout <<"Invalid number of villages entered." <<endl; //can't have negative village 

		} else {

			world.updateVillages(numofvill);

			for (k = 0; k < 40000; k++) {	//run the program 40000 times to get a good measure of probability

				numofdrops = 0;	//resets the number of drops in a given case for use

				for (j = 0; j < numofvill; j++) {

					world.village[j] = 0;	//resets the amounts in all of the villages to zero for new simulation

				}

				for (j = 0;;j++) { //continue the campaign until one of the village gets a supply amount of 100
				
					if (j == 0){

						actualLanding = planeLocation; //at the beginning the plane starts at the middle of all the village locations

					}

					if (actualLanding != -1) {	//if the value returned from function is -1 then skip it cause the supply did not land at any of the villages

						world.village[actualLanding] += world.supplyAmount();	//add a random amount of supplies to the village

					}

					nextTarget = world.nextVillage(planeLocation, numofvill);	//gets which village is to receive the supplies next
		
					if (world.village[nextTarget] >= 100) {

						break;	//if the village picked by the function above already has 100 or more units of supplies, then the campaign in over

					}

					planeLocation = nextTarget;	//the next village is where the plane will be to drop the supplies
					actualLanding = world.supplyLand(planeLocation, numofvill);	//where the supplies will land
					numofdrops++;	//+1 to the number of drops made
				}
			
				world.totalDrops += numofdrops;	//calculate the total number of drops for a given campaign

				for (i = 0; i < 18; i++) {

					ccount = ((numofvill * 2) + ((i * factor) + i) + factor);

					if (ccount >= numofdrops) {
			
						world.hcount[i]++;	//catergorizes the number of drops in each campaign to it respective sections
						break;	

					}
				}

				if (numofdrops > ccount) {

					world.hcount[17]++;	//if the number of drops exceed the limits of the categories, it goes into the last one

				}
			}
		}

	world.displayResults(numofvill, factor);

	}
}

//The results are somewhat different from the sample, but the process is essentially the same. I think the problem is somewhere
//in the function where it picks out which village is next, but i can't see any problems that might arise. The highest probability
//tends to flucuated between 18 to 19 and 20 to 21, again it's mostly due to the problem described above.