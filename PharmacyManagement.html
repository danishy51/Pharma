<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharma Management System</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-slate-100 text-slate-800 font-sans">
    <header class="bg-blue-600 text-white p-4 shadow-md">
        <h1 class="text-2xl font-bold text-center">Pharmacy Management System</h1>
    </header>

    <main class="max-w-6xl mx-auto m-6 grid grid-cols-1 md:grid-cols-3 gap-6">
        <!-- Form Section -->
        <div class="bg-white p-5 rounded-lg shadow-sm border border-slate-200">
            <h2 class="text-lg font-semibold mb-4 border-b pb-2">Add New Medicine</h2>
            <form id="medicineForm" class="space-y-4">
                <div>
                    <label class="block text-sm font-medium text-slate-600">Medicine Name</label>
                    <input type="text" id="medName" required class="w-full mt-1 p-2 border rounded-md focus:ring-2 focus:ring-blue-500 outline-none">
                </div>
                <div>
                    <label class="block text-sm font-medium text-slate-600">Price (PKR)</label>
                    <input type="number" id="medPrice" required class="w-full mt-1 p-2 border rounded-md focus:ring-2 focus:ring-blue-500 outline-none">
                </div>
                <div>
                    <label class="block text-sm font-medium text-slate-600">Stock Quantity</label>
                    <input type="number" id="medStock" required class="w-full mt-1 p-2 border rounded-md focus:ring-2 focus:ring-blue-500 outline-none">
                </div>
                <button type="submit" class="w-full bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-md transition font-medium">Add to Inventory</button>
            </form>
        </div>

        <!-- Inventory Table Section -->
        <div class="md:col-span-2 bg-white p-5 rounded-lg shadow-sm border border-slate-200">
            <h2 class="text-lg font-semibold mb-4 border-b pb-2">Current Inventory</h2>
            <div class="overflow-x-auto">
                <table class="w-full text-left border-collapse">
                    <thead>
                        <tr class="bg-slate-50 border-b text-slate-600 text-sm">
                            <th class="p-3">Item Name</th>
                            <th class="p-3">Price</th>
                            <th class="p-3">Stock</th>
                            <th class="p-3 text-center">Action</th>
                        </tr>
                    </thead>
                    <tbody id="inventoryList"></tbody>
                </table>
            </div>
            
            <div class="mt-6 p-4 bg-slate-50 border rounded-md flex justify-between items-center">
                <span class="text-lg font-bold">Total Sales Bill: PKR <span id="grandTotal">0</span></span>
            </div>
        </div>
    </main>

    <script>
        let inventory = [
            { id: 1, name: "Panadol 500mg", price: 30, stock: 100 },
            { id: 2, name: "Brufen 400mg", price: 55, stock: 50 }
        ];
        let grandTotal = 0;

        function renderTable() {
            const list = document.getElementById("inventoryList");
            list.innerHTML = "";
            inventory.forEach((item, index) => {
                list.innerHTML += `
                    <tr class="border-b hover:bg-slate-50">
                        <td class="p-3 font-medium">${item.name}</td>
                        <td class="p-3">PKR ${item.price}</td>
                        <td class="p-3">${item.stock}</td>
                        <td class="p-3 text-center">
                            <button onclick="sellItem(${index})" class="bg-green-600 hover:bg-green-700 text-white text-sm px-3 py-1 rounded-md transition">Sell 1</button>
                        </td>
                    </tr>
                `;
            });
        }

        document.getElementById("medicineForm").addEventListener("submit", function(e) {
            e.preventDefault();
            const name = document.getElementById("medName").value;
            const price = parseFloat(document.getElementById("medPrice").value);
            const stock = parseInt(document.getElementById("medStock").value);

            inventory.push({ id: Date.now(), name, price, stock });
            renderTable();
            this.reset();
        });

        function sellItem(index) {
            if (inventory[index].stock > 0) {
                inventory[index].stock -= 1;
                grandTotal += inventory[index].price;
                document.getElementById("grandTotal").innerText = grandTotal;
                renderTable();
            } else {
                alert("Out of stock!");
            }
        }

        renderTable();
    </script>
</body>
</html>
