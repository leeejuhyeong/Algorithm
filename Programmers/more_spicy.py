import heapq

def solution(scoville, K):
    answer = 0

    heapq.heapify(scoville)
    while True:
        if scoville[0] < K:
            if len(scoville) == 1:
                answer = -1
                break
            temp1 = heapq.heappop(scoville)
            temp2 = heapq.heappop(scoville)
            temp1 = temp1 + (temp2 * 2)
            heapq.heappush(scoville, temp1)
            answer += 1
        else:
            break
    return answer

if __name__ == "__main__":
    scoville = [1, 2, 3, 9, 10, 12]
    K = 7
    print(solution(scoville, K))