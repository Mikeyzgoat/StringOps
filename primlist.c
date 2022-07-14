// prims algo using adjacency lists
#include<stdio.h>
#include<stdlib.h>
typedef struct LIST{
    struct NODE *head;
}list;
typedef struct NODE{
    int src;
    int dest;
    int ew; //edge weight
    list *array;
    struct NODE *link;
}node;

node *getnode(){
    node *temp;
    temp = (node*)malloc(sizeof(node));
    return temp;
}


void prim(node *plarr,int n){
    node *temp;
    int vis[n],unv[n];
    vis[0] = 1;
    unv[0] = 0;
    for(int i=1;i<n;i++){
        vis[i] = 0;
        unv[i] = 1;
    }
    int cost = 0;
    int sr1,index,k=0;
    for(int i = 1;i<n;i++){
        int min = 999;
        for(int j = 0;j<n;j++){
            if(vis[j] == 1){
                while((temp!= NULL) && (k<=n)){
                    temp = plarr->array[k].head->link;
                    if((unv[k] == 1) && (temp->ew != 999)){
                        if(min > temp->ew){
                            min = temp->ew;
                            sr1 = temp->src;
                            index = temp->dest;
                        }
                        else{
                            temp = temp->link;
                        }
                    }
                }
            }
        }
        vis[index] = 1;
        unv[index] = 0;
        cost += min;
        printf("Edge b/w %d and %d has been added (cost %d)\n",sr1+1,index+1,min);
    }
    printf("\nCost of the MCST is : %d\n",cost);
}

int main(){
    int n,sr,de,ew;
    printf("Enter number of vertices : ");
    scanf("%d",&n);
    node *plarr;
    plarr = getnode();
    plarr->array = (list*)malloc(n*sizeof(list));// creating linked list array to hold all the edges
    for(int i=0;i<n;i++){
        plarr->array[i].head = NULL;
    } 
    printf("Enter <src,dest,edge weight> : \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d",&sr);
            scanf("%d",&de);
            scanf("%d",&ew);
            insert_rear(plarr,sr,de,ew);
        }
    }
    printf("\nNumber of edges in the MCST : %d",n-1);
    prim(plarr,n);
    return 0;
}