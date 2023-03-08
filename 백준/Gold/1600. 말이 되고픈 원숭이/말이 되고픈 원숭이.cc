#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <utility>
using namespace std;


int load[200][200];
bool che[200][200][30];

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int k = 0;
    int W = 0, H = 0;
    
    int knightX[8] = { 1, -1, 2, 2, 1, -1, -2, -2};
    int knightY[8] = { 2, 2, 1, -1, -2, -2, -1, 1};

    int moveY[4] = {1,0,-1,0};
    int moveX[4] = {0,1,0,-1};

    cin >> k;
    cin >> W >> H;
    
    for(int y = 0; y < H; y++)for(int x = 0; x < W; x++){cin >> load[y][x];}

    for(int i = 0; i < H; i++)for(int j = 0; j < W; j++)for(int t = 0; t < k; t++)che[i][j][t] = false;

    
    queue<pair<pair<int,int>,int>> que;
    que.push({{0,0},0});
    int count = -1;
    bool flg = true;
    che[0][0][0] = true;

    while(!que.empty() && flg){
        count++;
        int size = que.size();
        for(int m = 0; m < size; m++){
            int y = que.front().first.first;
            int x = que.front().first.second;
            int kCount = que.front().second;
            // cout << "y : " << y << " x : " << x << " kCount : " << kCount<< '\n';
            if(x == W-1 && y == H-1) {flg = false; break;}
            
            que.pop();


            if(kCount < k){
                for(int j = 0; j < 8; j++){
                    int ky = y + knightY[j];
                    int kx = x + knightX[j]; 
                    int kk = kCount + 1;
                    if(0 <= ky && ky < H &&  0 <= kx && kx < W && load[ky][kx] == 0){
                        if(!che[ky][kx][kk]){
                            que.push( {{ky,kx} , kk});
                            che[ky][kx][kk]=true;
                        }
                    }
                }
            }        
                
            for(int i = 0; i < 4; i++){
                int my = y + moveY[i];
                int mx = x + moveX[i];
                if(0 <= my && my < H &&  0 <= mx && mx < W && load[my][mx] == 0){
                    if(!che[my][mx][kCount]){
                        que.push({ {my,mx}, kCount });
                        che[my][mx][kCount]=true;
                    }            
                }

            }
        }
        
    }
    if(flg) cout << -1;
    else cout << count;
    return 0;
}
