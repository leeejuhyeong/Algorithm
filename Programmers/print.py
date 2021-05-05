def solution(priorities, location):
    cnt = 1

    while True:
        flag = 0
        for i in range(1, len(priorities) - 1):
            if priorities[0] < priorities[i]:
                flag = 1
                if location != 0:
                    location -= 1
                else:
                    location = len(priorities) - 1
                temp = priorities[0]
                priorities.pop(0)
                priorities.append(temp)
                break

        if flag == 0 and location == 0:
            break

        if flag == 0:
            priorities.pop(0)
            location -= 1
            cnt += 1

    answer = cnt
    return answer

if __name__ == "__main__":
   priorities = [1, 1, 9, 1, 1, 1]
   location = 0
   print(solution(priorities, location))