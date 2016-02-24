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
	for (i = 1; i < size - 1; i+=3) {
		if (i < size && i != 1) {
			fprintf(fpout, ", ");
			printf(", ");
		}
		fprintf(fpout, "(%1.17f, %1.17f)", (coordinates + i)->x, (coordinates + i)->y);
		printf("(%f, %f)", (coordinates + i)->x, (coordinates + i)->y);
        

//        temp = closestPoint((coordinates + i)->x, (coordinates + i)->y, coordinates, size);
//        
//        fprintf(fpout, "(%1.16f, %1.16f)", (temp)->x, (temp)->y);
//        printf("(%f, %f)", (temp)->x, (temp)->y);
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
