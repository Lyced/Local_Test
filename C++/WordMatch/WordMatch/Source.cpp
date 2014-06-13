#include <iostream>
#include <fstream>
#include <iomanip>
#include <string.h>
#include <conio.h>
#include <ctype.h>
using namespace std;


// global constants
const maxWords = 400,     // the maximum number of words that can be handled
      maxWordLength = 30; // the maximum word length that can be handled


bool readWordList (char wordList[][maxWordLength+1], int &words) { //function to read in from file

  const int maxFilenameLength = 60;
  
  char filename[maxFilenameLength + 1], word[maxWordLength + 1];
  ifstream fin;

  cout << "Enter filename for word list: ";
  cin >> filename;

  fin.open (filename);
  if (fin.fail()) {
    cout << "Unable to open file.\n";
    return false;
  }

  words = 0;

  for (;;) {

    fin >> setw(maxWordLength + 1) >> word;

    if (fin.fail()) {
      if (fin.eof()) {
        return true; // read failed because they are no more words
      }
      // read failed for some other reason
      cout << "An error occurred in reading the file.\n";
      return false;
    }

    strcpy (wordList[words], word); 
    words++;

  }

}

bool stringContained (const char str2[], const char str1[]) { // returns true if all of the characters of str2 occur,
												  // in the correct order, within str1.

	int i,j, b = 0, count = 0;

	for (i = 0; str1[i] != '\0'; i++) {

		if (i == 0) {
			j = 0;
		} else { 
			j = b + 1;
		}
		for (; str2[j] != '\0'; j++) {

			if ((str2[j] <= 'Z') || (str1[i] <= 'Z')) {	//taking into account capital letters and making them lower case
				if ((str2[j] <= 'Z') && ('A' <= str2[j])) {

					if ((char) (str2[j] + 32) == str1[i]) {
						count++;
						b = j;
						break;
					}
				} 
				if ((str1[i] <= 'Z') && ('A' <= str1[i])){

					if (str2[j] == (char) (str1[i] + 32)) {
						count++;
						b = j;
						break;
					}
				}
			} else if (str2[j] == str1[i]) {
				count++;
				b = j;
				break;
			}
			if (str1[i] == '\0' && count == 0){
				return false;
			}
		}
	}
	if (i != count && str1[i] == '\0') { 
		return false;	//if the number of chars occuring in both strings doesn not equals the length of the word entered, then return false
	} 
	if (i == count && str1[i] == '\0') { 
		return true;	//if the number of chars occuring in both strings and it equals the length of the word entered, then return true
	}
}

bool nearlyEqual (const char wordList[], const char word[]) {	// returns true if the two strings have the same length
																// and have exactly one difference.

	int i, count = 0;

	if (strlen (word) == strlen (wordList)) {

		for (i = 0; i < maxWordLength+1; i++) {

			if (word[i] == '\0') {
				break;
			}
			if ((word[i] <= 'Z') || (wordList[i] <= 'Z')) {	//taking into account capital letters and making them lower case
				if ((word[i] <= 'Z') && ('A' <= word[i])) {

					if ((char) (word[i] + 32) != wordList[i]) {
						count++;
					}
				} 
				if ((wordList[i] <= 'Z') && ('A' <= wordList[i])){

					if (word[i] != (char) (wordList[i] + 32)) {
						count++;
					}
				}
			} else if (word[i] != wordList[i]) {
				count++;
			}
			if (count > 1) {
				return false;	//if more then one char is different then return false
			}
		}
		if (count == 1) {
			return true;	//otherwise if only one char is different then return true
		}
	}
	return false;
}

void main () {	//main function

  char wordList[maxWords][maxWordLength + 1],
       word[maxWordLength + 1];
  int i, words, possibleMatches;
  bool wordIsOnList;

  if (!readWordList(wordList, words)) {
    cout << "Unable to read word list file.\n";
    return;
  }

  cout << "Word list (" << words << " words) successfully read.\n";

  for (;;) {

    cout << "Please enter a word (STOP to terminate): ";
    cin >>word;	//gets the string entered by the user
    
	if (stricmp(word, "STOP") == 0) {
		return;	//if the special string is inputted regardless of upper or lower case then exit
	}

    wordIsOnList = false;
    for (i = 0; i < words; i++) {

      if (stricmp (word, wordList[i]) == 0) {
        cout << "That word is on the list.\n";
        wordIsOnList = true;
        break;
      }

    }

    if (!wordIsOnList) {

      possibleMatches = 0;
      for (i = 0; i < words; i++) {

        if (stringContained (word, wordList[i])) {
          cout << "Did you add letters to " << wordList[i] << "?" << endl;
          possibleMatches++;
        }

        if (stringContained (wordList[i], word)) {
          cout << "Did you remove letters from " << wordList[i] << "?" << endl;
          possibleMatches++;
        }

        if (nearlyEqual (wordList[i], word)) {
          cout << "Did you get one letter wrong in " << wordList[i] << "?" << endl;
          possibleMatches++;
        }

      }

      cout << possibleMatches << " possible matches found.\n";

    }

  }
}


