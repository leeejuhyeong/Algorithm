import heapq

def solution(operations):
    heap = []
    max_heap = []

    for operation in operations:
        temp = operation.split()
        temp[1] = int(temp[1])

        if temp[0][0] == "I":
            heapq.heappush(heap, temp[1])
            heapq.heappush(max_heap, -temp[1])

        else:
            if temp[1] == 1:
                if len(heap) == 0:
                    continue
                else:
                    max = heapq.heappop(max_heap)
                    heap.remove(-max)
                    heapq.heapify(heap)
            else:
                if len(heap) == 0:
                    continue
                else:
                    min = heapq.heappop(heap)
                    max_heap.remove(-min)
                    heapq.heapify(max_heap)

    if len(heap) == 0:
        answer = [0, 0]
    else:
        answer = [-max_heap[0], heap[0]]

    return answer

if __name__ == "__main__":
    operations = ["I 2","I 4","D -1", "I 1", "D 1"]
    print(solution(operations))