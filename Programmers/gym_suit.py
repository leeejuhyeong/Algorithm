def solution(n, lost, reserve):
    priority = []
    member = [1] * n

    for i in lost:
        member[i - 1] -= 1

    for i in reserve:
        if member[i-1] == 0:
            member[i-1] += 1
        else:
            priority.append([i, 0])

    for i in lost:
        for j in range(len(priority)):
            if priority[j][0] == i - 1:
                priority[j][1] += 1
            if priority[j][0] == i + 1:
                priority[j][1] += 1

    priority.sort(key=lambda x: x[1])

    for i in priority:
        if i[0] != 1 and member[i[0] - 2] == 0:
            member[i[0] - 2] += 1
        elif i[0] != n and member[i[0]] == 0:
            member[i[0]] += 1

    answer = sum(member)
    return answer

if __name__ == "__main__":
    n = 5
    lost = [2, 4]
    reserve = [1, 3, 5]
    print(solution(n, lost, reserve))