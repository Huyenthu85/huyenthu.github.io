n=int(input().strip());
ds=list(map(int,input().split()))
if len(ds)==n and set(ds) == set(range(1,n+1)) :
    print("YES");
else:
    print("NO");
    
