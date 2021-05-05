def solution(bridge_length, weight, truck_weights):
    crossing = []
    time = 0
    total_weight = 0


    while True:
        if total_weight == 0 and len(truck_weights) == 0:
            break

        if len(crossing) == bridge_length:
            total_weight -= crossing[0]
            crossing.pop(0)

        if len(truck_weights) > 0:
            if total_weight + truck_weights[0] <= weight:
                temp = truck_weights[0]
                crossing.append(temp)
                total_weight += truck_weights[0]
                truck_weights.pop(0)

            else:
                crossing.append(0)
        else:
            crossing.append(0)

        time += 1

    answer = time
    return answer

if __name__ == "__main__":
    bridge_length = 2
    weight = 10
    truck_weights = [7,4,5,6]
    print(solution(bridge_length, weight, truck_weights))