def solution(m, n, puddles):
    mapping = []

    for i in range(n+1):
        mapping.append([0]*(m+1))

    for puddle in puddles:
        mapping[puddle[1]][puddle[0]] += -1

    mapping[1][1] = 1
    for y in range(1, n+1):
        for x in range(1, m+1):
            #mapping[y][x] = mapping[y-1][x] + mapping[y][x-1]
            if x == y == 1:
                continue
            if mapping[y][x] == -1:
                mapping[y][x] = 0
                continue
            mapping[y][x] = mapping[y-1][x] + mapping[y][x-1]

    return mapping[n][m] % 1000000007


if __name__ == "__main__":
    m = 4
    n = 3
    puddles = [[2, 2]]
    print(solution(m, n, puddles))