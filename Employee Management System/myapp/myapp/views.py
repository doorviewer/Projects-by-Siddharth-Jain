import datetime
from django.http import HttpResponse
from django.shortcuts import render

def index(request):
    if request.method=='POST':
        check = request.POST.get("check")
        print(check)
        if check is None: isActive = False
        else: isActive = True
    date = datetime.datetime.now()
    print("index function is called.")
    name="learnCodewithDurgesh"
    list_of_programs=[
        'WAP to check even or odd',
        'WAP to check prime number',
        'WAP to print all prime numbers from 1 to 100',
        'WAP to print pascals triangle']
    
    student={
        'student_name':"rahul",
        'student_college':"jamia",
        'student_city':'LUCKNOW'
    }

    data={
        'date':date,
        'isActive':isActive,
        'name':name,
        'list_of_programs':list_of_programs,
        'student_data':student
    }
    # return HttpResponse("<h1>Hello this is index page.</h1>" + str(date))
    return render(request,"about.html",data)

def home(request):
    date = datetime.datetime.now()
    print("test function is called view")
    return render(request,"home.html",{})


def about(request):
    return HttpResponse("<h1>Hello this is about page.</h1>")

def services(request):
    return HttpResponse("<h1>Hello this is services page.</h1>")