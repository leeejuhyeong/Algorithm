def solution(numbers, target):
    answer = [0]

    dfs(0, 0, numbers, target, answer)

    return answer[0]


def dfs(num, i, numbers, target, answer):
    if len(numbers) == i:
        if num == target:
            answer[0] += 1
    else:
        dfs(num + numbers[i], i + 1, numbers, target, answer)
        dfs(num - numbers[i], i + 1, numbers, target, answer)

if __name__ == "__main__":
    numbers = [1, 1, 1, 1, 1]
    target = 3
    print(solution(numbers, target))