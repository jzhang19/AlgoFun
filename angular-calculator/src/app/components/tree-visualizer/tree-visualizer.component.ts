import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-tree-visualizer',
  templateUrl: './tree-visualizer.component.html',
  styleUrls: ['./tree-visualizer.component.scss']
})
export class TreeVisualizerComponent implements OnInit {
  @Input() syntaxTreeFormula: any;

  constructor() { }

  ngOnInit(): void {
  }

  deleteNode() {
    this.syntaxTreeFormula = null;
  }
}
