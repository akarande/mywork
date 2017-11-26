#include<iostream>
#include<set>
#include<map>
#include<string>
#include<stdio.h>
#include<sstream>
#include<algorithm>
#include<queue>
#include<cmath>
#include<string.h>
using namespace std ;
#define INF (int)1e9

/* LCS Problem with multiple solutions
*/

// Computing length
// 2^(m + n)
int lcs(string s1, string s2) {
 if (s1.size() == 0 || s2.size() == 0) return 0 ;
 if (s1[0] == s2[0]) return 1 + lcs(s1.substr(1), s2.substr(1)) ;

 int l1 = lcs(s1.substr(1), s2) ;
 int l2 = lcs(s1, s2.substr(1)) ;
 return max(l1, l2) ;
}

// Reconstruction
// 2^(m + n) * (m + n)
string lcsString(string s1, string s2) {
 if (s1.size() == 0 || s2.size() == 0) return "" ;
 if (s1[0] == s2[0]) return s1[0] + lcsString(s1.substr(1), s2.substr(1)) ;

 string l1 = lcsString(s1.substr(1), s2) ;
 string l2 = lcsString(s1, s2.substr(1)) ;
 return l1.size() > l2.size() ? l1 : l2 ;
}


string s1, s2 ;
int memo[50][50] ;

// Computing length with Dynamic Programming
// m * n
int lcsTable() {
  for (int k1 = s1.size();k1 >= 0;k1--)
    for (int k2 = s2.size();k2 >= 0;k2--) {
      if (k1 == s1.size() || k2 == s2.size()) memo[k1][k2] = 0 ;
      else if (s1[k1] == s2[k2]) memo[k1][k2] = 1 + memo[k1 + 1][k2 + 1] ;
      else memo[k1][k2] = max(memo[k1 + 1][k2], memo[k1][k2 + 1]) ;
    }
  return memo[0][0] ;
}

// Computing length with index passing optimization and memoization
// O(m * n)
int lcs(int k1, int k2) {
 if (k1 == s1.size() || k2 == s2.size()) return 0 ;
 if (memo[k1][k2] != -1) return memo[k1][k2] ;
 if (s1[k1] == s2[k2]) return memo[k1][k2] = 1 + lcs(k1 + 1, k2 + 1) ;

 int l1 = lcs(k1 + 1, k2) ;
 int l2 = lcs(k1, k2 + 1) ;
 return memo[k1][k2] = max(l1, l2) ;
}

// Reconstruction
// m + n

// Need to call lcs() first before calling this, which will take O(m * n)
string answer;
void lcsReconstruct(int k1, int k2) {
 if (k1 == s1.size() || k2 == s2.size()) return;
 if (s1[k1] == s2[k2]) {
  answer.push_back(s1[k1]) ;
  lcsReconstruct(k1 + 1, k2 + 1) ;
  return ;
 }

 if (memo[k1 + 1][k2] > memo[k1][k2 + 1]) {
  lcsReconstruct(k1 + 1, k2) ;
 } else {
  lcsReconstruct(k1, k2 + 1) ;
 }
}


int main() {
 cin >> s1 >> s2 ;

 memset(memo, 255, sizeof memo) ;
 cout << lcs(0, 0) << endl ;
 lcsReconstruct(0, 0);
 cout << answer << endl ;

 cout << lcsTable() << endl ;

 cout << lcsString(s1, s2) << endl ;

 return 0 ;
}
