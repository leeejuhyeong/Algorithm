def solution(n, times):
    answer = 0
    lt = min(times)
    rt = max(times) * n

    while lt <= rt:
        mid = (lt + rt) // 2
        count = 0
        for time in times:
            count += mid // time

        if count >= n:
            rt = mid - 1
            answer = mid
        else:
            lt = mid + 1

    return answer

if __name__ == "__main__":
    n = 6
    times = [7, 10]
    print(solution(n, times))