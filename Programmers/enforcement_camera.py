def solution(routes):
    answer = 0
    routes.sort()
    print(routes)

    stack = [routes[0][:]]

    for i in range(1, len(routes)):
        if routes[i][0] > stack[0][1]:
            stack.pop(0)
            stack.append(routes[i])
            answer += 1
        else:
            if routes[i][0] >= stack[0][0]:
                stack[0][0] = routes[i][0]
            if routes[i][1] <= stack[0][1]:
                stack[0][1] = routes[i][1]

    if stack:
        answer += 1

    return answer

if __name__ == "__main__":
    routes = [[-20, 15], [-14, -5], [-18, -13], [-5, -3]]
    print(solution(routes))