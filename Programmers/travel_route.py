def solution(tickets):
    answer = []
    finish = [0] * len(tickets)
    answer.append("ICN")
    flag =[0]
    DFS("ICN", tickets, finish, answer, flag)

    return answer

def DFS(start, tickets, finish, answer, flag):
    if sum(finish) == len(tickets):
        flag[0] = 1
        return
    arr = []
    for idx, ticket in enumerate(tickets):
        if ticket[0] == start:
            arr.append([ticket[1], idx])
    arr.sort()
    for i in range(len(arr)):
        if finish[arr[i][1]] == 0:
            finish[arr[i][1]] = 1
            answer.append(arr[i][0])
            DFS(arr[i][0], tickets, finish, answer, flag)
            if flag[0] == 1:
                return
            else:
                answer.pop()
                finish[arr[i][1]] = 0

if __name__ == "__main__":
    tickets = [['ICN','A'],['A','B'],['A','C'],['C','A'],['B','D']]
    print(solution(tickets))