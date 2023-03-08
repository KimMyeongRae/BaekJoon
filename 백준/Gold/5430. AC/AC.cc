#include <iostream>
#include <math.h>
#include <sstream>
#include <deque>
using namespace std;

int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    deque<int> v;
    //d -> size 0 break;
    
    int t = 0;

    cin >> t;
    string p = "";
    string number = "";
    int temp = 0;
    bool reverse = false;
    bool flg = true;

    for(int i = 0; i < t; i++){
        reverse = false;
        flg = true, p = "", temp = 0, number ="";

        cin >> p; // 명령
        cin >> temp; // 배열 갯수
        cin >> number;
        v.clear();

        number.erase(0, 1);
        number.erase(number.size() - 1, 1);
        
        
        if(number.length() > 0){
            stringstream ss(number);
            for(int j; ss >> j;){
                v.push_back(j);
                if(ss.peek() == ',')ss.ignore();  
            }
        }

        
        for(int j = 0; j < p.length(); j++){
            if(p[j] == 'R'){
                if(reverse) reverse = false;
                else reverse = true;
            }else{ // D
                if(v.empty()){
                    cout << "error" << '\n';
                    flg = false;
                    break;
                }else{
                    if(reverse) // 뒤집혔네 ? 
                        v.pop_back();
                    else //안뒤집혔네 ? 
                        v.pop_front();
                }
            }
        }


        if(flg){
            cout << '[';
            if(reverse){
                for(int j = v.size() - 1; j >= 0; j--){
                    if(j != 0) cout << v[j] << ',';
                    else cout << v[j];
                }
            }else{
                for(int j = 0; j < v.size(); j++){
                    if(j != v.size() - 1) cout << v[j] << ',';
                    else cout << v[j];
                }
            }
            cout << ']' << '\n';
        }

    }

    return 0;
}
