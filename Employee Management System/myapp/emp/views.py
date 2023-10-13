from django.http import HttpResponse

from django.shortcuts import redirect, render

from emp.models import Emp

# Create your views here.

def emp_home(request):

    emps = Emp.objects.all()

    return render(request,"emp/home.html",{
        'emps' : emps
    })

def add_emp(request):
    if request.method == "POST":

        emp_name = request.POST.get("emp_name")
        emp_ID = request.POST.get("emp_ID")
        emp_phone = request.POST.get("emp_phone")
        emp_address = request.POST.get("emp_address")
        emp_department = request.POST.get("emp_department")
        emp_working = request.POST.get("emp_working")

        e = Emp()
        e.name = emp_name
        e.emp_ID = emp_ID
        e.phone = emp_phone
        e.address = emp_address
        e.department = emp_department

        if emp_working is None:
            e.working = False
        else:
            e.working = True
        
        e.save()

        print("Data is coming!")
        return redirect("/emp/home/")
    return render(request,"emp/add_emp.html",{})

def delete_emp(request,emp_ID):
    emp = Emp.objects.get(pk=emp_ID)    
    emp.delete()
    return redirect("/emp/home/")