import heapq

def solution(jobs):
    time = 0
    working = []
    jobs.sort(key=lambda x:(x[0], x[1]))
    n = len(jobs)

    while True:
        if len(jobs) == 0:
            break
        if time <= jobs[0][0]:
            time = jobs[0][0]
        heap = []
        for job in jobs:
            if job[0] <= time:
                heapq.heappush(heap, [job[1], job])
            else:
                break

        temp = heapq.heappop(heap)
        working.append(temp[0] + time - temp[1][0])
        time += temp[0]
        jobs.remove(temp[1])

    answer = sum(working) // n

    return answer

if __name__ == "__main__":
    jobs = [[43,20], [15, 34], [26,1], [47,22], [24,10], [15, 2], [37,5], [28,39], [35,43], [20,47]]
    print(solution(jobs))