#include <iostream>
using namespace std;
int FindMinMoveTime(long long i_Length);

int main() {
	long long i_Length = 0, i_Count = 0;
	long long i_X = 0, i_Y = 0; // i_X 는 시작지점 i_Y 는 종료지점.
	int i_LoopCount = 0;
	cin >> i_LoopCount;
	for(int i = 0; i <i_LoopCount; i++){
		cin >> i_X >> i_Y;
		i_Length = i_Y - i_X;
		
		cout << FindMinMoveTime(i_Length) << endl;
	}
	return 0;
}
int FindMinMoveTime(long long i_Length){
	int i_Count = 2, i_MoveHistory = 0;
	long long i_MoveLength = 0, i_PosMove = 1;
	while(i_Length > i_MoveLength){
		for(int i = 0; i < i_Count; i++){
			i_MoveLength += i_PosMove;
			i_MoveHistory++;
			if(i_Length <= i_MoveLength)break;
		}
		i_PosMove++;
	}
	return i_MoveHistory;
}