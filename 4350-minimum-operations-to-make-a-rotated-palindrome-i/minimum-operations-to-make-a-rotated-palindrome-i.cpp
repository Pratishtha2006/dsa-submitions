int fun(string s){
    int i=0,j=s.size()-1;

    int cost=0;

    while(i<j){
        if(s[i]!=s[j]){
            int a1=s[i]-'a';
            int a2=s[j]-'a';
            int c1=abs(a1-a2);
            int c2=26-abs(a1-a2);
            cost+=min(c1,c2);
        }
        i++;
        j--;
    }

    return cost;
}

class Solution {
public:
    int minOperations(string s) {
        int m=1e9;

        for(int i=0;i<s.size();i++){
            int cost=fun(s)+i;
            m=min(m,cost);
            s+=s[0];
            s.erase(s.begin());

        }

        cout<<fun("abc");

        return m;
    }
};