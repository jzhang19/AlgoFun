import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-tree-visualizer',
  templateUrl: './tree-visualizer.component.html',
  styleUrls: ['./tree-visualizer.component.scss'],
})
export class TreeVisualizerComponent implements OnInit {
  @Input() syntaxTreeFormula: any;
  @Output() syntaxTreeFormulaChange = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  deleteNode() {
    this.syntaxTreeFormulaChange.emit();
  }

  handleDeleteNode(pos: string) {
    console.log(pos);
    if (pos == 'left') {
      this.syntaxTreeFormula.left = null;
    } else if (pos == 'right') {
      this.syntaxTreeFormula.right = null;
    } else if (pos == 'all') {
      if (this.syntaxTreeFormula.expression) {
        this.syntaxTreeFormula.expression = null;
      } else if (this.syntaxTreeFormula.arguments) {
        this.syntaxTreeFormula.arguments = null;
      } else {
        this.syntaxTreeFormula = null;
      }
    }
  }
}
