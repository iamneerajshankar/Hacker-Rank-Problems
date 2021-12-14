#python program to demonstrate the probability of positive,negative and zero integers

class PlusMinus:

    #function to define logic 
    def plus_minus(self, arr, numberOfElements):

        # initialize the count of zero, positive and negative integers
        countZero, countPlus, countMinus = 0,0,0

        # iterate each element and check if the elmement is <,>,== 0
        for i in range(0, numberOfElements):
            if arr[i]>0:
                countPlus = countPlus +1
            if arr[i]<0:
                countMinus = countMinus + 1
            if arr[i]==0:
                countZero = countZero +1

        # find the probability of positive, negative and zero integers respectively 
        PostiveInteger = float(countPlus)/float(numberOfElements)
        NegativeInteger = float(countMinus)/float(numberOfElements)
        ZeroInteger = float(countZero)/float(numberOfElements)

        #Print the probability of the occurrence with precision upto 6 decimal places
        print("The probability of the Positive Integer: ", end =" ")
        print("%.6f" %PostiveInteger) # precision using percent operator
        print("The probability of the Negative Integer: ", end =" ")
        print("{0:.6f}".format(NegativeInteger)) # precision using format method 
        print("The probability of the Zero Integer: ", end =" ")
        print(round(ZeroInteger, 6)) # precision using round function 


# driver code
if __name__ == "__main__":
    
    myArr = list(map(int, input().split()))
    n = len(myArr)

    #create object of the class PlusMinus
    obj = PlusMinus()

    # calling the member function
    obj.plus_minus(myArr, n)