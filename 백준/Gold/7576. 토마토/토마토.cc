#include <iostream>
#include <queue>
#include <vector>

using namespace std;



int bfs(int targetCount, vector<vector<int>> c, queue<vector<int>> startingPoint) {
	
	
	int maxY = c.size();
	int maxX = c[0].size();
	
	int day = 0;
	int count = 0;

	

	while (targetCount > count) {
		day++;

		int queueLength = startingPoint.size();
		if (!queueLength) return -1;


		for (int i = 0; i < queueLength; i++) {
			int y = startingPoint.front()[0];
			int x = startingPoint.front()[1];			

			if (x + 1 < maxX && c[y][x + 1] == 0) {
				c[y][x + 1] = 1;				
				startingPoint.push({ y, x + 1 });
				count++;
			}

			if (x - 1 > -1  && c[y][x - 1] == 0) {
				c[y][x - 1] = 1;				
				startingPoint.push({ y, x -1});
				count++;
			}

			if (y + 1 < maxY && c[y + 1][x] == 0) {
				c[y + 1][x] = 1;				
				startingPoint.push({ y + 1, x});
				count++;
			}

			if (y -1 > -1 && c[y - 1][x] == 0) {
				c[y - 1][x] = 1;				
				startingPoint.push({ y - 1, x});
				count++;
			}

			startingPoint.pop();									
		}
	}
	

	return day;
}
int main()
{
	int x = 0, y = 0;
	

	cin >> x >> y;


	int day = 0;
	
	
	vector<vector<int>> c(y);
	int targetCount = 0;
	queue<vector<int>> startingPoints;



	for(int i = 0; i < y; i++){
		for (int j = 0; j < x; j++) {			
			int temp = 0;
			cin >> temp;

			if (temp == 0) {
				targetCount++;
				c[i].push_back(0);
			}
			else if (temp == 1) {
				c[i].push_back(1);
				vector<int> v = { i, j };				
				startingPoints.push(v);
			}
			else {
				c[i].push_back(-1);
			}
					
		}
	}	
	cout << bfs(targetCount, c, startingPoints) << endl;
	return 0;	
}