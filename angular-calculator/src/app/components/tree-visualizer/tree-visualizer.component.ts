import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-tree-visualizer',
  templateUrl: './tree-visualizer.component.html',
  styleUrls: ['./tree-visualizer.component.scss']
})
export class TreeVisualizerComponent implements OnInit {
  @Input() syntaxTree: any;
  
  constructor() { }

  ngOnInit(): void {
    console.log("Child: ", this.syntaxTree);
  }

}
