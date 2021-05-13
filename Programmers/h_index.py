def solution(citations):
    answer = 0

    citations.sort(reverse=True)
    paper = len(citations)
    average = sum(citations) // paper

    for citation in citations:
        if citation <= average:
            average = citation
            break

    while True:
        count = 0
        for citation in citations:
            if average <= citation:
                count += 1
            else:
                break
        if count >= average >= paper-count:
            break
        else:
            average -= 1
    answer = average
    return answer

if __name__ == "__main__":
    citations = [3, 0, 6, 1, 5]
    print(solution(citations))