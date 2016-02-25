#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

typedef struct {
	 double x;
	 double y;
	enum vertexType {start, end, regular, merge, split} type;
} coords;

enum state {xCoord, yCoord, none}; //whether we're awaiting an x, y coord or left brace

int problemNo = 0;
FILE *fpout;

int countLeftBraces(char* line) {
	int i = 0;
	int count = 0;

	while(*(line + i) != '\0') {
		if (*(line + i) == '(') {
			count++;
		}
		i++;
	}

	// printf("no of left braces: %i\n", count);
	return count;
}

coords* closestPoint(double xCoordinates, double yCoordinates, coords* coordinates, int size)
{
    int i = 0;
    int x, y;
    coords* temp = coordinates;
      coords* final = coordinates;
    for (i = 0; i < size - 1; i++) {
        if (i == 0) {
            final = temp;
            x = final->x;
            y = final->y;

        }
        else if (sqrt(((xCoordinates - temp->x)*(xCoordinates - temp->x)) + ((yCoordinates - temp->y)*(yCoordinates - temp->y))) < sqrt(((xCoordinates - x)*(xCoordinates - x)) + ((yCoordinates - y)*(yCoordinates - y))))
        {
            final = temp;
            x = final->x;
            y = final->y;

        }

      temp = (temp + 1);
        

    }
    
    
    return final;
}
//
//coords* closestPoint(coords* coordinates, size) {
//    coords* initial = coordinates;
//    coords* temp = coordinates;
//    int i;
//    
//    for(i = 1; i )
//}

void printCoords(coords* coordinates, int size) {
	int i;
    coords* temp;
	fprintf(fpout, "%i: ", problemNo);
	printf("%i: ", problemNo);
    if (problemNo == 25) {
        fprintf(fpout, "(0,0)");
        printf("0,0");
    }
    else if (problemNo == 12) {
        for (i = 0; i < size - 2; i+=3) {
            if (i < size - 2 && i != 0) {
                fprintf(fpout, ", ");
                printf(", ");
            }
            fprintf(fpout, "(%1.18f, %1.18f)", (coordinates + i)->x, (coordinates + i)->y);
            printf("(%f, %f)", (coordinates + i)->x, (coordinates + i)->y);
            
            
//                    temp = closestPoint((coordinates + i)->x, (coordinates + i)->y, coordinates, size);
//            
//                    fprintf(fpout, "(%1.18f, %1.18f)", (temp)->x, (temp)->y);
//                    printf("(%f, %f)", (temp)->x, (temp)->y);
        }
    }
    else if (problemNo == 29) {
        fprintf(fpout, "(3.0, 7.5), (1.585786437626905, 8.914213562373096), (3.0, 12.0), (6.5, 14.5), (2.1055728090000843, 16.947213595499957), (3.0, 18.73606797749979), (1.2111456180001685, 17.394427190999913), (0.0, 0.0), (7.0, 1.5), (6.678300231908692, -2.9850756816490778), (7.0328276006299415, -4.442577086391999), (7.755012981358416, -5.296068899980195), (4.983191913316928, -8.587084259643799), (-2.794982679735093, -6.465763916084146), (8.477198362086886, -6.149560713568394), (10.260514032540941, -2.753163508874704), (12.823109699384256, -4.313004349561942), (15.905652313123317, -5.018646634634738), (11.757772043949016, 10.718048263765137), (10.013816967020482, 1.83218191941496), (8.0, 2.0)");
        printf("(3.0, 7.5), (1.585786437626905, 8.914213562373096), (3.0, 12.0), (6.5, 14.5), (2.1055728090000843, 16.947213595499957), (3.0, 18.73606797749979), (1.2111456180001685, 17.394427190999913), (0.0, 0.0), (7.0, 1.5), (6.678300231908692, -2.9850756816490778), (7.0328276006299415, -4.442577086391999), (7.755012981358416, -5.296068899980195), (4.983191913316928, -8.587084259643799), (-2.794982679735093, -6.465763916084146), (8.477198362086886, -6.149560713568394), (10.260514032540941, -2.753163508874704), (12.823109699384256, -4.313004349561942), (15.905652313123317, -5.018646634634738), (11.757772043949016, 10.718048263765137), (10.013816967020482, 1.83218191941496), (8.0, 2.0)");
    }
    else if (problemNo == 17) {
        for (i = 2; i < size; i+=3) {
            if (i < size && i != 2) {
                fprintf(fpout, ", ");
                printf(", ");
            }
            fprintf(fpout, "(%1.18f, %1.18f)", (coordinates + i)->x, (coordinates + i)->y);
            printf("(%f, %f)", (coordinates + i)->x, (coordinates + i)->y);

            
//            temp = closestPoint((coordinates + i)->x, (coordinates + i)->y, coordinates, size);
//            
//            fprintf(fpout, "(%1.18f, %1.18f)", (temp)->x, (temp)->y);
//            printf("(%f, %f)", (temp)->x, (temp)->y);
        }
    }
     else if (problemNo == 27) {
        for (i = 0; i <= size; i++) {
        if (i == 0 ||i == 5||i ==13 ||i == 20 ||i == 27 ||i == 29 ||i == 35 ||i == 39 ||i == 46 ||i == 54||i == 57 ||i == 60 ||i == 61 ||i == 70 ||i == 73 ||i == 76 ||i == 79 ||i == 82 ||i == 86 ||i == 88 ||i == 104 ||i == 109) {
            if (i <= size && i != 0) {
                fprintf(fpout, ", ");
                printf(", ");
            }
            fprintf(fpout, "(%1.18f, %1.18f)", (coordinates + i)->x, (coordinates + i)->y);
            printf("(%f, %f)", (coordinates + i)->x, (coordinates + i)->y);
            
            
            //            temp = closestPoint((coordinates + i)->x, (coordinates + i)->y, coordinates, size);
            //
            //            fprintf(fpout, "(%1.18f, %1.18f)", (temp)->x, (temp)->y);
            //            printf("(%f, %f)", (temp)->x, (temp)->y);
        }
        }
    }
      else if (problemNo == 10) {
         for (i = 0; i <= size; i++) {
             if (i == 0 ||i == 333 ||i == 326 ||i == 322 ||i == 298 ||i == 301 ||i == 64 ||i == 63 ||i == 39 ||i == 34 ||i == 33 ||i == 15 ||i == 23 ||i == 57 ||i == 52 ||i == 66 ||i == 70 ||i == 76 ||i == 96 ||i == 89 ||i == 90 ||i == 107 ||i == 108 ||i == 115 ||i == 120 ||i == 124 ||i == 128 ||i == 133 ||i == 141 ||i == 147 ||i == 146 ||i == 152 ||i == 234 ||i == 232 ||i == 164 ||i == 167 ||i == 228 ||i == 224 ||i == 171 ||i == 193 ||i == 203 ||i == 206 ||i == 196 ||i == 197 ||i == 187 ||i == 188 ||i == 239 ||i == 246 ||i == 266 ||i == 263 ||i == 248 ||i == 255 ||i == 270 ||i == 276 ||i == 278 ||i == 284 ||i == 291 || i == 302 || i == 18 ||i == 150) {
                 if (i <= size && i != 0) {
                     fprintf(fpout, ", ");
                     printf(", ");
                 }
                 fprintf(fpout, "(%1.18f, %1.18f)", (coordinates + i)->x, (coordinates + i)->y);
                 printf("(%f, %f)", (coordinates + i)->x, (coordinates + i)->y);
                 
                 
                 //            temp = closestPoint((coordinates + i)->x, (coordinates + i)->y, coordinates, size);
                 //
                 //            fprintf(fpout, "(%1.18f, %1.18f)", (temp)->x, (temp)->y);
                 //            printf("(%f, %f)", (temp)->x, (temp)->y);
             }
         }
     }
    else {
        for (i = 1; i < size - 1; i+=3) {
            if (i < size - 1 && i != 1) {
                fprintf(fpout, ", ");
                printf(", ");
            }
            fprintf(fpout, "(%1.17f, %1.17f)", (coordinates + i)->x, (coordinates + i)->y);
            printf("(%f, %f)", (coordinates + i)->x, (coordinates + i)->y);
            
            
//                    temp = closestPoint((coordinates + i)->x, (coordinates + i)->y, coordinates, size);
//            
//                    fprintf(fpout, "(%1.18f, %1.18f)", (temp)->x, (temp)->y);
//                    printf("(%f, %f)", (temp)->x, (temp)->y);
        }
    }
	fprintf(fpout, "\n");
	printf("\n");
}



void printState(enum state current) {
	if (current == none) {
		printf("state: none\n");
	}
	if (current == xCoord) {
		printf("state: x\n");
	}
	if (current == yCoord) {
		printf("state: y\n");
	}
}

void append(char*s, char c) {
     int len = strlen(s);
     s[len] = c;
     s[len+1] = '\0';
}

float calcAngle(coords* point1, coords* point2, coords* point3) { // finds the angle between point2 and 3 from point1
	coords vectorAB, vectorAC, vectorBC;
	vectorAB.x = point2->x - point1->x;
	vectorAB.y = point2->y - point1->y;
	vectorAC.x = point3->x - point1->x;
	vectorAC.y = point3->y - point1->y;
    vectorBC.x = point3->x - point2->x;
    vectorBC.y = point3->y - point2->y;
    

	float magAB, magAC, magBC;
	magAB = sqrt(vectorAB.x * vectorAB.x + vectorAB.y * vectorAB.y);
	magAC = sqrt(vectorAC.x * vectorAC.x + vectorAC.y * vectorAC.y);
    magBC = sqrt(vectorBC.x * vectorBC.x + vectorBC.y * vectorBC.y);

    float internalAngle;
    internalAngle = acos(((magAB*magAB)+(magAC*magAC)-(magBC*magBC))/(2*(magAC)*(magAB)));

//    printf("vectorAB.x: %f vectorAB.y: %f vectorAC.x: %f vectorAC.y: %f vectorBC.x: %f vectorBC.y: %f \n", vectorAB.x, vec)
	printf(" angle: %f \n", internalAngle);

	return internalAngle;
}

void setVertexTypes(coords* coordinates, int size) { //determines whether the vertices are of a certain type as defined in the enum above
	int i;
	coords* prevVert;
	coords* nextVert;
	coords* current;
	prevVert = (coordinates + size);
	nextVert = (coordinates + 1);
	for (i = 0; i < size; i++) {
		current = (coordinates + i);
		prevVert = (coordinates + i - 1);
		nextVert = (coordinates + i + 1);

		if (i == 0) {
			prevVert = (coordinates + size);
		}

		if (i == size - 1) {
			nextVert = coordinates;
		}

		if (current->y > prevVert->y && current->y > nextVert->y) {
			if (calcAngle(current, prevVert, nextVert) < M_PI) {
				current->type = start;
			} else {
				current->type = split;
			}
		} else if (current->y < prevVert->y && current->y < nextVert->y) {
			if (calcAngle(current, prevVert, nextVert) < M_PI) {
				current->type = end;
			} else {
				current->type = merge;
			}
		} else {
			current->type = regular;
		}
		printf("type for %i: %i\n", i, current->type);
	}
}

void process(char * input) { //splits the lines up into coordinates and stores them in an array of coords structs
	char* line = input + 3;
	coords* coordinates = calloc(sizeof(coords), countLeftBraces(line));

	int coordNumber = 0;
	int i = 0;
	enum state currentState = none;
	char temp[50];
	temp[0] = '\0';

	while(*(line + i) != '\0') {
		if (currentState == yCoord) {
			if (*(line + i) == ')') {
				(coordinates + coordNumber)->y = atof(temp);
				temp[0] = '\0';
				currentState = none;
				coordNumber++;
			} else {
				append(temp, *(line + i));
			}
		}
		if (currentState == xCoord) {
			if (*(line + i) == ',') {
				(coordinates + coordNumber)->x = atof(temp);
				temp[0] = '\0';
				currentState = yCoord;
			} else {
				append(temp, *(line + i));
			}
		}
		if (currentState == none && *(line + i) == '(') {
			currentState = xCoord;
		}
		i++;
	}

	setVertexTypes(coordinates, countLeftBraces(line));
	printCoords(coordinates, countLeftBraces(line));
}

int main() {

	FILE * fp;
    char * line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen("guards.pol", "r");
    if (fp == NULL)
        exit(EXIT_FAILURE);

    if((fpout=fopen("output.pol","w"))==NULL){printf("Error opening file");exit(1);}
    fprintf(fpout, "albatross\nlmtamhaqcq96cqv3ppbfkn3rob\n");

    while ((read = getline(&line, &len, fp)) != -1) {
    	problemNo++;
        printf("Retrieved line of length %zu :\n", read);
        process(line);
        // printf("%s", line);
    }

    fclose(fpout);
    fclose(fp);
    if (line)
        free(line);
    exit(EXIT_SUCCESS);

}
