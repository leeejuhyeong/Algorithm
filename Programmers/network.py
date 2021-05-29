def solution(n, computers):
    in_network = [0]*n
    networking = 0

    for i in range(n):
        if in_network[i] == 0:
            in_network[i] = 1
            DFS(i, in_network, computers)
            networking += 1
    return networking

def DFS(i, in_network, computers):
    com = computers[i]
    for j in range(len(com)):
        if com[j] == 1 and in_network[j] == 0:
            in_network[j] = 1
            DFS(j, in_network, computers)


if __name__=="__main__":
    n = 3
    computers = [[1, 1, 0], [1, 1, 1], [0, 1, 1]]
    print(solution(n, computers))