def minimum_budget(n,projects):

    max_penalty=0

    for i in range(n):

        expenditure, bonus, reward_penalty=projects[i]

        reward_penalty=int(reward_penalty)
        
    if reward_penalty<0:
        max_penalty=max(max_penalty,-reward_penalty)
    
    total_budget=sum(expenditure + bonus + max_penalty for expenditure, bonus, reward penalty in projects)

    return total_budget



n=int(input())

projects=[]

for in range(n):

    expenditure, bonus, reward_penalty=map(int, input().split())

    projects.append((expenditure, bonus, reward_penalty))



result=minimum_budget(n,projects)

print(result)
