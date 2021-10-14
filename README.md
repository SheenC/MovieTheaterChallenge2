<h1>Theater Seats Challenge</h1>

<h3>Run the Program</h3>
<p>
Run the "main" function in "Main" class.
The input file "input.txt" is put in the project file, 
the output file "outputTheater.txt" will also appear in the project file when you run the main function.
</p>

<h3>Customer Satisfaction Consideration</h3>
<p>
In order to make the seat reservation process fair
and make customers satisfied,
I will range the seat starting from the middle of rows and columns.
Rows will be prioritized than columns.
For rows, we arrange from middle to back, when it reaches the last row, we come back to the row before middle.
Then we start from middle to front rows.
For columns, we arrange from middle to right, whe it reaches the rightest column, we come back to the row before middle.
Then we start from middle to left rows.
</p>
<p>
For example,
we start from the middle row, which is row F, of the theater. 
When row F is full, we will arrange seats from middle to end, the row F, G, H , I, J sequentially.
After the last row, which is row J, is full, we jump to anther middle row, which is row E. 
We arrange seats from middle to the front, E, D, C, D, A sequentially.
For columns, we will also choose from the middle of the row.

</p>

<h3>Customer Safety Consideration</h3>
<p>
For the purpose of public safety, I will make a buffer of three
seats. Once the seats left is equal or less than three, 
the program will stop arranging seats
and tell the customer we cannot serve so many people.
</p>
