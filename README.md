# Percolation-Simulator
Based on the Princeton University project.

<div align="center">
  <img src="https://raw.githubusercontent.com/MateusGurgel/Percolation-Simulator/main/demo/Demo.PNG" />
</div>

&nbsp;

What is Percolation?

Percolation is a concept used in various fields to simulate the movement of substances through porous materials, such as fluids passing through interconnected pores in a material.

<div align="center">
  <img src="https://raw.githubusercontent.com/MateusGurgel/Percolation-Simulator/main/demo/percolation-100.png" />
<img src="https://raw.githubusercontent.com/MateusGurgel/Percolation-Simulator/main/demo/percolation-204.png" />
</div>

&nbsp;

About the Model:

In this Percolation-Simulator, we utilize an N by N boolean matrix to determine whether a site is open or closed. Additionally, we implement a quick-union flat tree data structure to track whether a site is connected or not. Percolation occurs when the virtual top of the tree becomes connected to its virtual bottom, indicating that there is a path for fluid to flow from the top to the bottom of the matrix.

The simulator enables researchers and students to experiment with different matrix sizes and densities of open sites. By doing so, users can observe and study the percolation phenomenon under various scenarios. This model has widespread applications, including the understanding of phase transitions, network connectivity, fluid flow in porous materials, electrical conductivity in networks, and more.
