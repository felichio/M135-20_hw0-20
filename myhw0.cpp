#include <iostream>
#include <vector>
#include <unordered_map>
#include <utility>
#include <string>
using namespace std;
int main(int argc, char *argv[]) {
    string q;
    vector<pair<int, int>> v;
    unordered_map<int, unordered_map<int, int>> s;
    while (cin >> q) {
        size_t d = q.find("|");
        const int k1 = stoi(q.substr(0, d)); // take first half A | B -> A
        if (!s.count(k1)) {
            unordered_map<int, int> w;
            s[k1] = w;
        }
        const int k2 = stoi(q.substr(d + 1)); // take second half A | B -> B
        if (!s[k1].count(k2)) {
            s[k1][k2] = s[k1].size() + 1; // [X of Y] -> size of (inners map prev state) + 1 gives us X effectively preserving the order of input data for specific key
        }
        v.push_back(make_pair(k1, k2));
    }
    for (pair<int, int> &p : v) {
        cout << p.first << "|" << p.second << "[" << s[p.first][p.second] << " of " << s[p.first].size() << "]" << endl;
    }
    return 0;
}
