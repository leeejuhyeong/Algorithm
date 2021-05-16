def solution(n, computers):
    in_network = [0]*n
    network_count = 0

    for i in range(n):
        if in_network[i] == 0:
            in_network[i] = 1
            DFS(i, in_network, computers)
            network_count += 1

    return network_count

def DFS(now, in_network, computers):
    for i in range(now, len(computers[now])):
        if computers[now][i] == 1 and in_network[i] == 0:
            in_network[i] = 1
            DFS(i, in_network, computers)


if __name__ == "__main__":
    n = 3
    computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
    print(solution(n, computers))