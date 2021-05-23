def solution(number, k):
    stack = []
    for i in number:
        while stack and k > 0:
            if stack[-1] < i:
                stack.pop()
                k -= 1
            else:
                break
        stack.append(i)

    if k != 0:
        stack = stack[:-k]

    answer = ''.join(stack)
    return answer

if __name__ == "__main__":
    number = "999"
    k = 2
    print(solution(number, k))