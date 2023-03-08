#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <deque>
using namespace std;

int map[100][100][100];

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);    
    int moveX[6] = {0, 1, 0, -1 , 0, 0};
    int moveY[6] = {1, 0, -1, 0, 0, 0};
    int moveZ[6] ={0, 0, 0, 0, 1, -1};
    
    //N : Y M : X Z : H 
    //2 <= M <= 100 
    //2 <= N <= 100
    //1 <= H <= 100

    queue<pair<pair<int,int>, int>> que;
    //y x z

    int my = 0, mx = 0, mz = 0;

    cin >> mx >> my >> mz;
    int count = 0, target = 0;

    for(int i = 0; i < mz; i++){
        for(int j = 0; j < my; j++){
            for(int k = 0; k < mx; k++){
                cin >> map[i][j][k];
                if(map[i][j][k] == 1){que.push({{j, k}, i});}
                else if(map[i][j][k] == 0) target++;
            }
        }
    }

    bool flg = false;

    int day = 0;

    while(!que.empty()){
        if(target == count) {flg = true; break;}
        int size = que.size();
        day++;    
        for(int queSize = 0; queSize < size; queSize++){
            int y = que.front().first.first;
            int x = que.front().first.second;
            int z = que.front().second;
            // cout << y << ' ' << x << ' ' << z << endl;
            que.pop();
            for(int i =0; i < 6; i++){
                int ny = y + moveY[i];
                int nx = x + moveX[i];
                int nz = z + moveZ[i];
                if( 0 <= ny && ny < my &&
                    0 <= nx && nx < mx &&
                    0 <= nz && nz  < mz && map[nz][ny][nx] == 0){
                    map[nz][ny][nx] = 1;
                    // cout << nz << ' ' <<
                    //     ny << ' ' <<
                    //     nx << '\n';
                    count++;
                    que.push({{ny, nx}, nz});
                }
            }
        }
    }

    if(flg) cout << day;
    else cout << -1;
    // cout << day << endl;
    // cout << count << endl;
    return 0;
}
