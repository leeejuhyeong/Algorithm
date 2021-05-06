def solution(prices):
    stack = []

    answer = [0] * len(prices)
    stack.append([0, prices[0]])

    for i in range(1, len(prices)):
        if stack[-1][1] > prices[i]:
            while stack:
                if stack[-1][1] > prices[i]:
                    answer[stack[-1][0]] = i - stack[-1][0]
                    stack.pop()
                else:
                    break
        stack.append([i, prices[i]])
    length = len(stack)
    for i in range(length):
        answer[stack[0][0]] = stack[-1][0] - stack[0][0]
        stack.pop(0)

    return answer


if __name__ == "__main__":
    prices = [1, 2, 3, 2, 3]
    print(solution(prices))