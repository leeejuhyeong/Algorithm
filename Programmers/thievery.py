def solution(money):
    dy = [0] * (len(money))
    dy[0] = money[0]
    dy[1] = max(money[0], money[1])

    for i in range(2, len(money) - 1):
        dy[i] = max(dy[i - 1], dy[i - 2] + money[i])

    dy2 = [0] * (len(money))
    dy2[0] = 0
    dy2[1] = money[1]

    for i in range(2, len(money)):
        dy2[i] = max(dy2[i - 1], dy2[i - 2] + money[i])

    return max(max(dy), max(dy2))


if __name__ == "__main__":
    money = [1, 2, 3, 1]
    print(solution(money))
