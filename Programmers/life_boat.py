def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    stack = []
    stack.append(people[0])

    for i in range(1, len(people)):
        if stack[-1] + people[i] <= limit:
            stack.pop()
            answer += 1
        else:
            stack.append(people[i])

    answer += len(stack)
    return answer

if __name__ == "__main__":
    people = [70, 50, 80, 50]
    limit = 100
    print(solution(people, limit))