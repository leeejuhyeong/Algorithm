def solution(progresses, speeds):
    answer = []
    publish = progresses

    while len(publish) > 0:
        cnt = 0
        if len(publish) == 0:
            break
        else:
            for j in range(len(publish)):
                if publish[j] < 100:
                    publish[j] += speeds[j]

            while len(publish) > 0:
                if publish[0] >= 100:
                    publish.pop(0)
                    speeds.pop(0)
                    cnt += 1
                else:
                    break

        if cnt != 0:
            answer.append(cnt)

    return answer


if __name__ == "__main__":
    progresses = [95, 90, 99, 99, 80, 99]
    speeds = [1, 1, 1, 1, 1, 1]
    print(solution(progresses, speeds))
