#include <iostream>
#include <deque>
#include <vector>
#include <cstring> //memset
using namespace std;

const int MAX = 50;

typedef struct {
	int y, x;
}Dir;

Dir moveDir[4] = { {1,0},{-1,0},{0,1},{0,-1} };


int T, N, M, K;
int farm[MAX][MAX];
bool visited[MAX][MAX];
vector<int> v;
int cnt;

void DFS(int y, int x) {

	visited[y][x] = true;

	for (int i = 0; i < 4; i++) {

		int nextY = y + moveDir[i].y;
		int nextX = x + moveDir[i].x;

		if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
			if (farm[nextY][nextX] == 1 && visited[nextY][nextX] == false) {
				DFS(nextY, nextX);
			}
		}
	}
}

int main(void) {

	cin >> T;
	
	for (int i = 0; i < T; i++) {

		cnt = 0;
		memset(farm, 0, sizeof(farm));
		memset(visited, false, sizeof(visited));
		cin >> M >> N >> K;
		int a, b;

		for (int j = 0; j < K; j++) {
			cin >> a >> b;
			farm[b][a] = 1;
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (farm[y][x] == 1 && visited[y][x] == false) {
					cnt++;
					DFS(y, x);
				}
			}
		}
		v.push_back(cnt);
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << endl;
	}

	return 0;
}