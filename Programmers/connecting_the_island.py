def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x: x[2])
    cycle = []
    for i in range(n):
        cycle.append(i)

    for cost in costs:
        answer += union_find(cost, cycle)
        if sum(cycle) == 0:
            break

    return answer

def getParent(i, cycle):
    if cycle[i] == i:
        return i
    return getParent(cycle[i], cycle)

def union_find(i, cycle):
    first = getParent(i[0], cycle)
    second = getParent(i[1], cycle)

    if cycle[first] == cycle[second]:
        return 0

    if first < second:
        cycle[second] = first
    else:
        cycle[first] = second

    return i[2]

if __name__ == "__main__":
    n = 6
    costs = [[0, 1, 5], [0, 3, 2], [0, 4, 3], [1, 4, 1], [3, 4, 10], [1, 2, 2], [2, 5, 3], [4, 5, 4]]
    print(solution(n, costs))