package com.example.zoompantrial;



public class Vertices {
	
	public void Vertices(){
		
		
		Vertex v0 = new Vertex("490,533"); 
		Vertex v1 = new Vertex("496,520");
		Vertex v2 = new Vertex("524,529");
		Vertex v3 = new Vertex("540,529");
		Vertex v4 = new Vertex("540,517");
		Vertex v5 = new Vertex("505,505");
		Vertex v6 = new Vertex("511,490");
		Vertex v7 = new Vertex("513,475");
		Vertex v8 = new Vertex("535,500");
		Vertex v9 = new Vertex("541,487");
		Vertex v10 = new Vertex("555,487");
		Vertex v11 = new Vertex("557,464");
		Vertex v12 = new Vertex("544,465");
		Vertex v13 = new Vertex("542,473");
		Vertex v14 = new Vertex("513,465");
		Vertex v15 = new Vertex("526,452");
		Vertex v16 = new Vertex("540,454");
		Vertex v17 = new Vertex("543,434");
		Vertex v18 = new Vertex("553,424");
		Vertex v19 = new Vertex("565,436");
		Vertex v20 = new Vertex("558,417");
		Vertex v21 = new Vertex("589,443");
		Vertex v22 = new Vertex("558,455");
		Vertex v23 = new Vertex("569,466");
		Vertex v24 = new Vertex("578,473");
		Vertex v25 = new Vertex("592,473");
		Vertex v26 = new Vertex("602,445");
		Vertex v27 = new Vertex("614,451");
		Vertex v28 = new Vertex("609,466");
		Vertex v29 = new Vertex("604,476");
		Vertex v30 = new Vertex("628,457");
		Vertex v31 = new Vertex("634,445");
		Vertex v32 = new Vertex("591,424");
		Vertex v33 = new Vertex("564,404");
		
		
		v0.adjacencies = new Edge[]{ new Edge(v1, calculateDistance(returnX(v0), returnY(v0), returnX(v1), returnY(v1)))};
		v1.adjacencies = new Edge[]{ new Edge(v0, calculateDistance(returnX(v0), returnY(v0), returnX(v1), returnY(v1))),
				new Edge(v5,  calculateDistance(returnX(v5), returnY(v5), returnX(v1), returnY(v1))),
				new Edge(v2, calculateDistance(returnX(v2), returnY(v2), returnX(v1), returnY(v1))) };
		v2.adjacencies = new Edge[]{ new Edge(v1, calculateDistance(returnX(v2), returnY(v2), returnX(v1), returnY(v1))),
				new Edge(v3,calculateDistance(returnX(v2), returnY(v2), returnX(v3), returnY(v3)))};
		v3.adjacencies = new Edge[]{ new Edge(v4, calculateDistance(returnX(v3), returnY(v3), returnX(v4), returnY(v4))),
				new Edge(v2,  calculateDistance(returnX(v2), returnY(v2), returnX(v3), returnY(v3)))};
		v4.adjacencies = new Edge[]{ new Edge(v3, calculateDistance(returnX(v4), returnY(v4), returnX(v3), returnY(v3))),
				new Edge(v5,calculateDistance(returnX(v4), returnY(v4), returnX(v5), returnY(v5))),
				new Edge(v10,calculateDistance(returnX(v10), returnY(v10), returnX(v4), returnY(v4)))};
		v5.adjacencies = new Edge[]{ new Edge(v1,  calculateDistance(returnX(v5), returnY(v5), returnX(v1), returnY(v1))),
				new Edge(v6,  calculateDistance(returnX(v5), returnY(v5), returnX(v6), returnY(v6)))};
		v6.adjacencies = new Edge[]{ new Edge(v7,  calculateDistance(returnX(v7), returnY(v7), returnX(v6), returnY(v6))),
				new Edge(v5,  calculateDistance(returnX(v6), returnY(v6), returnX(v5), returnY(v5))),
				new Edge(v9,calculateDistance(returnX(v6), returnY(v6), returnX(v9), returnY(v9))),
				new Edge(v8,calculateDistance(returnX(v8), returnY(v8), returnX(v6), returnY(v6)))};
		v7.adjacencies = new Edge[]{ new Edge(v6, calculateDistance(returnX(v6), returnY(v6), returnX(v7), returnY(v7))),
				new Edge(v8,calculateDistance(returnX(v8), returnY(v8), returnX(v7), returnY(v7)))};
		v8.adjacencies = new Edge[]{new Edge(v6,calculateDistance(returnX(v6), returnY(v6), returnX(v8), returnY(v8))),
				new Edge(v9, calculateDistance(returnX(v9), returnY(v9), returnX(v8), returnY(v8))),
				new Edge(v7,calculateDistance(returnX(v7), returnY(v7), returnX(v8), returnY(v8)))};
		v9.adjacencies = new Edge[]{new Edge(v10,calculateDistance(returnX(v10), returnY(v10), returnX(v9), returnY(v9))),
				new Edge(v6,calculateDistance(returnX(v6), returnY(v6), returnX(v9), returnY(v9)))};
		v10.adjacencies = new Edge[]{new Edge(v4,calculateDistance(returnX(v4), returnY(v4), returnX(v10), returnY(v10))),
			new Edge(v11,calculateDistance(returnX(v10), returnY(v10), returnX(v11), returnY(v11))),
				new Edge(v9,calculateDistance(returnX(v10), returnY(v10), returnX(v9), returnY(v9)))};
		v11.adjacencies = new Edge[]{new Edge(v12,calculateDistance(returnX(v12), returnY(v12), returnX(v11), returnY(v11))),
			new Edge(v10,calculateDistance(returnX(v10), returnY(v10), returnX(v11), returnY(v11))),
				new Edge(v22,calculateDistance(returnX(v22), returnY(v22), returnX(v11), returnY(v11))),
				new Edge(v23,calculateDistance(returnX(v23), returnY(v23), returnX(v11), returnY(v11)))};
		v12.adjacencies = new Edge[]{new Edge(v13,calculateDistance(returnX(v13), returnY(v13), returnX(v12), returnY(v12))),
				new Edge(v11,calculateDistance(returnX(v12), returnY(v12), returnX(v11), returnY(v11))),
				new Edge(v14,calculateDistance(returnX(v12), returnY(v12), returnX(v14), returnY(v14)))};
		//missing 14 in 13
		v13.adjacencies = new Edge[]{new Edge(v12,calculateDistance(returnX(v13), returnY(v13), returnX(v12), returnY(v12))),
				new Edge(v14,calculateDistance(returnX(v13), returnY(v13), returnX(v14), returnY(v14)))};
		v14.adjacencies = new Edge[]{new Edge(v13,calculateDistance(returnX(v13), returnY(v13), returnX(v14), returnY(v14))),
				new Edge(v15,calculateDistance(returnX(v15), returnY(v15), returnX(v14), returnY(v14)))};
		v15.adjacencies = new Edge[]{new Edge(v16,calculateDistance(returnX(v15), returnY(v15), returnX(v16), returnY(v16))),
				new Edge(v14,calculateDistance(returnX(v14), returnY(v14), returnX(v15), returnY(v15))),
				new Edge(v17,calculateDistance(returnX(v15), returnY(v15), returnX(v17), returnY(v17)))};
		v16.adjacencies = new Edge[]{new Edge(v15,calculateDistance(returnX(v15), returnY(v15), returnX(v16), returnY(v16))),
				new Edge(v19,calculateDistance(returnX(v16), returnY(v16), returnX(v19), returnY(v19)))};
		v17.adjacencies = new Edge[]{new Edge(v15,calculateDistance(returnX(v15), returnY(v15), returnX(v17), returnY(v17))),
				new Edge(v18,calculateDistance(returnX(v17), returnY(v17), returnX(v18), returnY(v18)))};
		v18.adjacencies = new Edge[]{new Edge(v17,calculateDistance(returnX(v17), returnY(v17), returnX(v18), returnY(v18))),
				new Edge(v19,calculateDistance(returnX(v19), returnY(v19), returnX(v18), returnY(v18))),
				new Edge(v20,calculateDistance(returnX(v20), returnY(v30), returnX(v18), returnY(v18)))};
		v19.adjacencies = new Edge[]{new Edge(v16,calculateDistance(returnX(v19), returnY(v19), returnX(v16), returnY(v16))),
				new Edge(v18,calculateDistance(returnX(v18), returnY(v18), returnX(v19), returnY(v19)))};
		v20.adjacencies = new Edge[]{new Edge(v18,calculateDistance(returnX(v18), returnY(v18), returnX(v20), returnY(v20))),
				new Edge(v21,calculateDistance(returnX(v20), returnY(v20), returnX(v21), returnY(v21))),
				new Edge(v33,calculateDistance(returnX(v33), returnY(v33), returnX(v20), returnY(v20)))};
		v21.adjacencies = new Edge[]{new Edge(v20,calculateDistance(returnX(v20), returnY(v20), returnX(v21), returnY(v21))),
				new Edge(v22,calculateDistance(returnX(v22), returnY(v22), returnX(v21), returnY(v21))),
				new Edge(v26,calculateDistance(returnX(v26), returnY(v26), returnX(v21), returnY(v21)))};
		v22.adjacencies = new Edge[]{new Edge(v11,calculateDistance(returnX(v22), returnY(v22), returnX(v11), returnY(v11))),
				new Edge(v21,calculateDistance(returnX(v22), returnY(v22), returnX(v21), returnY(v21)))};
		v23.adjacencies = new Edge[]{new Edge(v11,calculateDistance(returnX(v23), returnY(v23), returnX(v11), returnY(v11))),
				new Edge(v24,calculateDistance(returnX(v23), returnY(v23), returnX(v24), returnY(v24)))};
		v24.adjacencies = new Edge[]{new Edge(v23,calculateDistance(returnX(v24), returnY(v24), returnX(v23), returnY(v23))),
				new Edge(v25,calculateDistance(returnX(v24), returnY(v24), returnX(v25), returnY(v25)))};
		v25.adjacencies = new Edge[]{new Edge(v24,calculateDistance(returnX(v24), returnY(v24), returnX(v25), returnY(v25))),
				new Edge(v26,calculateDistance(returnX(v25), returnY(v25), returnX(v26), returnY(v26))),
				new Edge(v29,calculateDistance(returnX(v29), returnY(v29), returnX(v25), returnY(v25)))};
		v26.adjacencies = new Edge[]{new Edge(v25,calculateDistance(returnX(v25), returnY(v25), returnX(v26), returnY(v26))),
				new Edge(v21,calculateDistance(returnX(v26), returnY(v26), returnX(v21), returnY(v21))),
				new Edge(v27,calculateDistance(returnX(v27), returnY(v27), returnX(v26), returnY(v26)))};
		v27.adjacencies = new Edge[]{new Edge(v26,calculateDistance(returnX(v26), returnY(v26), returnX(v27), returnY(v27))),
				new Edge(v28,calculateDistance(returnX(v28), returnY(v28), returnX(v27), returnY(v27))),
				new Edge(v30,calculateDistance(returnX(v30), returnY(v30), returnX(v27), returnY(v27)))};
		v28.adjacencies = new Edge[]{new Edge(v27,calculateDistance(returnX(v27), returnY(v27), returnX(v28), returnY(v28))),
				new Edge(v29,calculateDistance(returnX(v29), returnY(v29), returnX(v28), returnY(v28))),
				new Edge(v30,calculateDistance(returnX(v30), returnY(v30), returnX(v28), returnY(v28)))};
		v29.adjacencies = new Edge[]{new Edge(v25,calculateDistance(returnX(v25), returnY(v25), returnX(v29), returnY(v29))),
				new Edge(v28,calculateDistance(returnX(v28), returnY(v28), returnX(v29), returnY(v29)))};
		v30.adjacencies = new Edge[]{new Edge(v27,calculateDistance(returnX(v30), returnY(v30), returnX(v27), returnY(v27))),
				new Edge(v28,calculateDistance(returnX(v30), returnY(v30), returnX(v28), returnY(v28))),
				new Edge(v31,calculateDistance(returnX(v30), returnY(v30), returnX(v31), returnY(v31)))};
		v31.adjacencies = new Edge[]{new Edge(v30,calculateDistance(returnX(v30), returnY(v30), returnX(v31), returnY(v31))),
				new Edge(v32,calculateDistance(returnX(v32), returnY(v32), returnX(v31), returnY(v31)))};
		v32.adjacencies = new Edge[]{new Edge(v31,calculateDistance(returnX(v32), returnY(v32), returnX(v31), returnY(v31))),
				new Edge(v33,calculateDistance(returnX(v33), returnY(v33), returnX(v32), returnY(v32)))};
		v33.adjacencies = new Edge[]{new Edge(v32,calculateDistance(returnX(v33), returnY(v33), returnX(v32), returnY(v32))),
				new Edge(v20,calculateDistance(returnX(v33), returnY(v33), returnX(v20), returnY(v20)))};
		
		Vertex[] vertices = {v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,
				v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31,v32,v33};

	}
	
	public double calculateDistance(int x1,int y1,int x2,int y2){
		double X = (x2-x1)*(x2-x1);
		double Y = (y2-y1)*(y2-y1);
		return (double)Math.sqrt(X+Y);
	}
	
	public int returnX(Object obj){
		String coor = ""+obj;
		String coord[] = coor.split(",");
		return Integer.parseInt(coord[0]);
	}
	public int returnY(Object obj){
		String coor = ""+obj;
		String coord[] = coor.split(",");
		return Integer.parseInt(coord[1]);
	}
}