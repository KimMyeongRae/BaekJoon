#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <deque>
using namespace std;


int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);    
    char command[4] = {'D', 'S', 'L', 'R'};
    /*
        D : n*2  > 9999  n*2%10000 else n*2
        S : n - 1 == 0 9999 else n - 1
        L : d2 d3 d4 d1 
        R : d4 d1 d2 d3
    */
    bool check[10000] = {};
    
    int t = 0;
    cin >> t;

    for(int testCase = 0; testCase < t; testCase++){
        int n = 0, target = 0;
        cin >> n >> target;
        
        queue<pair<int, string>> que;
        que.push({n, ""});
        for(int i = 0; i < 10000; i++) check[i] = false;
        check[n] = true;

        int nowNumber = 0;
        string nowCommand = "";

        while(!que.empty()){
            // int size = que.size();
            // for(int s = 0; s < size; s++){
                nowNumber = que.front().first;
                nowCommand = que.front().second;    
                que.pop();
                if(nowNumber == target)break;
                // int arr[4] ={};

                // int tn = nowNumber;
                // int w = 3;
                // while(tn > 0){arr[w] = tn %10; tn /= 10; w--;}
                

                for(int j = 0; j < 4; j++){
                   string newCommand = nowCommand + command[j];
                   int newNumber = nowNumber;
                   if(command[j] == 'D'){
                        newNumber*=2;
                        if(newNumber > 9999) newNumber %= 10000;
                   }else if(command[j] == 'S'){
                        newNumber -= 1;
                        if(newNumber < 0) newNumber = 9999;
                   }else if(command[j] == 'L'){
                        // newNumber = (arr[1] * 1000) + (arr[2] * 100) + (arr[3] * 10) + arr[0];
                        newNumber = (nowNumber % 1000) * 10 + (nowNumber / 1000);
                   }else if(command[j] == 'R'){
                        // newNumber = (arr[3] * 1000) + (arr[0] * 100) + (arr[1] * 10) + arr[2];
                        newNumber = (nowNumber % 10) * 1000 + (nowNumber/10);
                   }
                    if(!check[newNumber]) {que.push({newNumber, newCommand}); check[newNumber] = true;}
                   
                }

            // }
        }

        cout << nowCommand << '\n';   
    }
    return 0;
}
