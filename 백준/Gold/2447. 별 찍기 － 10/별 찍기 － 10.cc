#include <iostream>
using namespace std;
int SearchSpace(char c_StarSpace[][6561], int i_Y, int i_X, int i_Number, int i_ThreeSquare);
void InitalSpace(char c_StarSpace[][6561], int i_Length);
void Space(char c_StarSpace[][6561], int i_Y, int i_X, int i_Number, int i_ThreeSquare);
void SpaceX(char c_StarSpace[][6561], int i_Y, int i_X, int i_Number, int i_ThreeSquare);
void SpaceY(char c_StarSpace[][6561], int i_Y, int i_X, int i_Number, int i_ThreeSquare);
void PrintSpace(char c_StarSpace[][6561], int i_Length);
char c_StarSpace[6561][6561];

int main(){
    int i_Number = 0;
    
    cin >> i_Number;
   InitalSpace(c_StarSpace, i_Number); // c_StarSpace 초기화.
   SearchSpace(c_StarSpace, 0, 0, i_Number, 3);
   PrintSpace(c_StarSpace, i_Number);

}

int SearchSpace(char c_StarSpace[][6561],int i_Y,int i_X, int i_Number, int i_ThreeSquare) {
    
    if (i_ThreeSquare > i_Number)return true;
    
    if (i_X == i_Number) { // X 좌표가 넘어갔을경우.
        i_X = 0;
        i_Y += 1;
    }
    /*
    if (i_Y == i_Number) { // Y 좌표가 넘어갔을경우.(3을위한 조건)
        i_X = 0; i_Y = 0;
        return SearchSpace(c_StarSpace, i_Y, i_X, i_Number, i_ThreeSquare *= 3);
    }*/
    
    if (i_ThreeSquare == 3 && i_Y % 3 == 1 && i_X % 3) { //3은 따로빼줌.
        Space(c_StarSpace, i_Y, i_X, i_Number, i_ThreeSquare);
        return SearchSpace(c_StarSpace, i_Y, i_X + 1, i_Number, i_ThreeSquare *= 3);

    }
    else if (i_ThreeSquare > 3 && i_Y / (i_ThreeSquare / 3) == 1 && i_X / (i_ThreeSquare / 3) == 1) {
        Space(c_StarSpace, i_Y, i_X, i_Number, i_ThreeSquare);

        return SearchSpace(c_StarSpace, i_Y, i_X + 1, i_Number, i_ThreeSquare *= 3);
    }
    
    return SearchSpace(c_StarSpace,i_Y,i_X+1,i_Number,i_ThreeSquare);
}
void Space(char c_StarSpace[][6561], int i_Y, int i_X, int i_Number, int i_ThreeSquare) {
    for (int i = i_Y;  i < i_Y + ((i_ThreeSquare / 3)); i++) {
        for (int j = i_X; j < (i_X + (i_ThreeSquare / 3)); j++) {
            SpaceX(c_StarSpace, i, j, i_Number, i_ThreeSquare);
            if (i_ThreeSquare == 3)break;
        }
        if (i_ThreeSquare == 3)break;
    }
}
void SpaceY(char c_StarSpace[][6561],int i_Y,int i_X ,int i_Number, int i_ThreeSquare) {
    while (i_Y+i_ThreeSquare < i_Number) {
        i_Y += i_ThreeSquare;
        c_StarSpace[i_Y][i_X] = ' ';
    }
}
void SpaceX(char c_StarSpace[][6561], int i_Y, int i_X, int i_Number, int i_ThreeSquare) {
    int i_Count = 0;
    while (i_X+ i_Count < i_Number) {
        i_X += i_Count;
        if(i_Count == 0)i_Count = i_ThreeSquare;
        c_StarSpace[i_Y][i_X] = ' ';
        SpaceY(c_StarSpace, i_Y, i_X, i_Number, i_ThreeSquare);
    }
}
void InitalSpace(char c_StarSpace[][6561], int i_Length){
    for (int i_Y = 0; i_Y < i_Length; i_Y++) {
        for (int i_X = 0; i_X < i_Length; i_X++) {
            c_StarSpace[i_Y][i_X] = '*';
        }
    }   
}

void PrintSpace(char c_StarSpace[][6561], int i_Length){
    for (int i_Y = 0; i_Y < i_Length; i_Y++) {
        for (int i_X = 0; i_X < i_Length; i_X++) {
            cout << c_StarSpace[i_Y][i_X];
        }
        cout << endl;
    }
}